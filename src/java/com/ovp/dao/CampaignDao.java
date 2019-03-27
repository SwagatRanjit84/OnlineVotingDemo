/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovp.dao;

import com.ovp.entities.Campaign;
import com.ovp.entities.Candidate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rashmi Tiwari
 */
public class CampaignDao {
    private final static Logger log = Logger.getLogger("CampaignDao");

    public Campaign getCampaign(int campaignId) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        log.log(Level.INFO, "Getting campaign with Id:{0} from DB", campaignId);
        String query = "SELECT * FROM campaign WHERE id=" + campaignId;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            List<Campaign> lists = resultSetToCampaignList(resultSet);
            if (lists.isEmpty()) {
                return null;
            } else {
                return lists.get(0);
            }
        } catch(SQLException ex){
            log.log(Level.SEVERE, "getting  campaign:{0} failed in DB", ex);
            throw ex;
        }finally {
            DBUtil.close(resultSet);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
    }
    
    public Campaign getActiveCampaign() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        log.log(Level.INFO, "Getting active campaign from DB");
        String query = "SELECT * FROM campaign WHERE "
                + "STARTDATE < DATE(NOW()) and "
                + "ENDDATE > DATE(NOW()) and "
                + "STARTTIME > TIME(NOW()) and "
                + "ENDTIME < TIME(NOW())";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            List<Campaign> lists = resultSetToCampaignList(resultSet);
            if (lists.isEmpty()) {
                return null;
            } else {
                return lists.get(0);
            }
        } catch(SQLException ex){
            log.log(Level.SEVERE, "getting active campaign:{0} failed in DB", ex);
            throw ex;
        }finally {
            DBUtil.close(resultSet);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
    }

    public List<Campaign> getAllCampaign() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        log.info("Getting all campaign from DB");
        String query = "SELECT * FROM campaign";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSetToCampaignList(resultSet);
        } finally {
            DBUtil.close(resultSet);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
    }

    public void createCampaign(Campaign campaign) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        log.log(Level.INFO, "Creating campaign:{0} in DB", campaign);
        String insertQuery = "INSERT INTO campaign(TITLE, STARTDATE, ENDDATE,STARTTIME,ENDTIME) VALUES(?,?,?,?,?)";
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, campaign.getTitle());
            stmt.setDate(2, new java.sql.Date(campaign.getStartDate().getTime()));
            stmt.setDate(3, new java.sql.Date(campaign.getEndDate().getTime()));
            stmt.setTime(4, new java.sql.Time(campaign.getStartTime().getTime()));
            stmt.setTime(5, new java.sql.Time(campaign.getEndTime().getTime()));
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                log.log(Level.SEVERE, "Creating campaign failed:{0} in DB", campaign);
                throw new SQLException("Creating campaign failed, no rows affected.");
            }
            // get primary key of the inserted row
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    campaign.setId(generatedKeys.getInt(1));
                    log.log(Level.INFO, "Campaign created:{0} in DB", campaign);
                } else {
                    log.log(Level.SEVERE, "Creating campaign failed:{0} in DB", campaign);
                    throw new SQLException("Creating campaign failed, no ID obtained.");
                }
            }
            catch(SQLException ex){
            log.log(Level.SEVERE, "Creating campaign:{0} failed in DB", ex);
            throw ex;
        }
        } finally {
            DBUtil.close(resultSet);
            DBUtil.close(stmt);
            DBUtil.close(connection);
        }
    }

    public void updateCampaign(Campaign campaign) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        log.log(Level.INFO, "Updating campaign:{0} in DB", campaign);
        String updateQuery = "UPDATE campaign SET TITLE=?, STARTDATE=?, ENDDATE=?"
                + "WHERE id=?";
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(updateQuery);

            stmt.setString(1, campaign.getTitle());
            stmt.setDate(2, new java.sql.Date(campaign.getStartDate().getTime()));
            stmt.setDate(3, new java.sql.Date(campaign.getEndDate().getTime()));
            stmt.setInt(4, campaign.getId());

            stmt.executeUpdate();
            log.log(Level.INFO, "Updated campaign:{0} in DB", campaign);

        } finally {
            DBUtil.close(resultSet);
            DBUtil.close(stmt);
            DBUtil.close(connection);
        }
    }
    
    public void deleteCampaign(Campaign campaign) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        log.log(Level.INFO, "Deleting campaign:{0} in DB", campaign);
        String updateQuery = "DELETE FROM campaign WHERE id=?";
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(updateQuery);
            stmt.setInt(1, campaign.getId());

            stmt.executeUpdate();
            log.log(Level.INFO, "Deleted campaign:{0} in DB", campaign);

        } finally {
            DBUtil.close(resultSet);
            DBUtil.close(stmt);
            DBUtil.close(connection);
        }
    }

    private List<Campaign> resultSetToCampaignList(ResultSet resultSet) throws SQLException {
        List<Campaign> campaignList = new ArrayList();
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            Date startDate = resultSet.getDate("startDate");
            Date endDate = resultSet.getDate("endDate");
            Time startTime = resultSet.getTime("startTime");
            Time endTime = resultSet.getTime("endTime");
            List<Candidate> contestentList = new ContestentDao().getAllContestent(id);
            System.out.println("id: " + id);
            System.out.println("title: " + title);
            System.out.println("startDate: " + startDate);
            System.out.println("endDate: " + endDate);
            
            // TODO: convert agentList array to real List and use it in constructor
            Campaign campaign = new Campaign(title, startDate, endDate, startTime ,endTime);
            campaign.setId(id);
            campaign.setContestentList(contestentList);
            campaignList.add(campaign);
        }
        return campaignList;
    }
}
