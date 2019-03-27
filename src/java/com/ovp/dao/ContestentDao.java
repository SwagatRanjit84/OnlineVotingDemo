/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovp.dao;

/**
 *
 * @author Rashmi Tiwari
 */
import com.ovp.entities.Candidate;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContestentDao {
    private final static Logger log = Logger.getLogger("ContestentDao");

    public Candidate getContestent(int contestentId) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        log.log(Level.INFO, "Getting Contestent with Id:{0} from DB", contestentId);
        String query = "SELECT * FROM candidate WHERE id=" + contestentId;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            List<Candidate> lists = resultSetToContestentList(resultSet);
            if (lists.isEmpty()) {
                return null;
            } else {
                return lists.get(0);
            }
        }
        catch(SQLException ex){
            log.log(Level.SEVERE, "getting  contestent:{0} failed in DB", ex);
            throw ex;
        }finally {
            DBUtil.close(resultSet);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
    }
    
    public List<Candidate> getAllContestent(int campaignId) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        log.info("Getting all contestent from DB");
        String query = "SELECT * FROM candidate WHERE campaign_id="+campaignId;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSetToContestentList(resultSet);
        } catch(SQLException ex){
            log.log(Level.SEVERE, "getting  contestent:{0} failed in DB", ex);
            throw ex;
        }
        finally {
            DBUtil.close(resultSet);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
    }
    
    public List<Candidate> getAllCandidate() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        log.info("Getting all contestent from DB");
        String query = "SELECT * FROM candidate ";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSetToContestentList(resultSet);
        } catch(SQLException ex){
            log.log(Level.SEVERE, "getting  contestent:{0} failed in DB", ex);
            throw ex;
        }
        finally {
            DBUtil.close(resultSet);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
    }
    
    public List<Candidate> getCandidateByPost(String post) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        log.info("Getting all contestent from DB");
        String query = "SELECT * FROM candidate WHERE post='"+post+"' order by vote DESC";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSetToContestentList(resultSet);
        } finally {
            DBUtil.close(resultSet);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
    }

    public void createContestent(Candidate contestent) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        log.log(Level.INFO, "Creating contestent:{0} in DB", contestent);
        String insertQuery = "INSERT INTO candidate(NAME,DISTRICT, PARTY, POST,VOTE, PHOTO_ID, CAMPAIGN_ID) VALUES(?,?,?,?,?,?,?)";
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, contestent.getName());
            stmt.setString(2, contestent.getDistrict());
            stmt.setString(3, contestent.getParty());
            stmt.setString(4, contestent.getPost());
            stmt.setInt(5, contestent.getVotes());
            stmt.setInt(6, contestent.getPhotoId());
            stmt.setInt(7, contestent.getCampaignId());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                log.log(Level.SEVERE, "Creating user failed:{0} in DB", contestent);
                throw new SQLException("Creating user failed, no rows affected.");
            }
            // get primary key of the inserted row
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    contestent.setId(generatedKeys.getString(1));
                    log.log(Level.INFO, "Contestent created:{0} in DB", contestent);
                } else {
                    log.log(Level.SEVERE, "Creating user failed:{0} in DB", contestent);
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch(SQLException ex){
            log.log(Level.SEVERE, "creating  contestent:{0} failed in DB", ex);
            throw ex;
        }finally {
            DBUtil.close(resultSet);
            DBUtil.close(stmt);
            DBUtil.close(connection);
        }
    }

    public void updateContestent(Candidate contestent) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        log.log(Level.INFO, "Updating contestent:{0} in DB", contestent);
        String updateQuery = "UPDATE candidate SET VOTE=? "
                + "WHERE id=?";
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(updateQuery);

            stmt.setInt(1, contestent.getVotes());
             stmt.setString(2, contestent.getId());

            stmt.executeUpdate();
            log.log(Level.INFO, "Updated contestent:{0} in DB", contestent);

        } finally {
            DBUtil.close(resultSet);
            DBUtil.close(stmt);
            DBUtil.close(connection);
        }
    }
    
    public void deleteContestent(Candidate contestent) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        log.log(Level.INFO, "Updating contestent:{0} in DB", contestent);
        String updateQuery = "DELETE FROM contestent WHERE id=?";
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(updateQuery);
            stmt.setString(0, contestent.getId());

            stmt.executeUpdate();
            log.log(Level.INFO, "Deleted contestent:{0} in DB", contestent);

        } finally {
            DBUtil.close(resultSet);
            DBUtil.close(stmt);
            DBUtil.close(connection);
        }
    }

    private List<Candidate> resultSetToContestentList(ResultSet resultSet) throws SQLException {
        List<Candidate> contestentList = new ArrayList();
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            //String picLoc = resultSet.getString("picloc");
            String post= resultSet.getString("post");
            String party= resultSet.getString("party");
            String district= resultSet.getString("district");
            String agenda = resultSet.getString("agenda");
            int vote = resultSet.getInt("vote");
            String summary = resultSet.getString("summary");
            int campaignId = resultSet.getInt("campaign_id");
            int photoId = resultSet.getInt("PHOTO_ID");
            
            System.out.println("Name: " + name);
            //System.out.println("Picloc: " + picLoc);
            System.out.println("agenda: " + agenda);
            System.out.println("Vote: " + vote);
            System.out.println("Summary: " + summary);
            System.out.println("campaignId: " + campaignId);
            // TODO: convert agentList array to real List and use it in constructor
            Candidate contestent = new Candidate();
            contestent.setId(id);
            contestent.setVotes(vote);
            contestent.setName(name);
            contestent.setDistrict(district);
            contestent.setParty(party);
            contestent.setPost(post);
            contestent.setPhotoId(photoId);
            contestent.setAgendaList(stringToList(agenda));
            contestentList.add(contestent);
        }
        return contestentList;
    }
    
    private String listToString(List<String> agendaList){
        StringBuilder builder = new StringBuilder();
        for(String agenda: agendaList) {
            builder.append(agenda+";");
        }
        return builder.toString();
    }
    
    private List<String> stringToList(String agenda){
        if ( agenda != null) {
        String[] agendas = agenda.split(";");
        return Arrays.asList(agendas);
        }
        else 
            return new ArrayList();
    }

}
