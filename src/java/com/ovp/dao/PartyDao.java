/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovp.dao;

import com.ovp.entities.Party;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rashmi Tiwari
 */
public class PartyDao {
     private final static Logger log = Logger.getLogger("PartyDao");
     DateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
    public void InsertParty(Party party)throws SQLException{
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        
        log.log(Level.INFO, "Creating party:{0} in DB", party);
        
        String insertQuery = "INSERT INTO party VALUES(?,?,?,?,?,?)";
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, party.getId());
            stmt.setString(2, party.getName());
            Date date = party.getEstablishedDate();
            
            String strDate = dateFormater.format(date);
            stmt.setString(3,strDate);
         
            stmt.setString(4, String.valueOf(party.getNumberOfMembers()));
            stmt.setString(5, party.getDescription());
            stmt.setInt(6, party.getPhotoId());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                log.log(Level.SEVERE, "Creating party failed:{0} in DB", party);
                throw new SQLException("Creating party failed, no rows affected.");
            }
            // get primary key of the inserted row
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    party.setId(Integer.valueOf(generatedKeys.getString(1)));
                    log.log(Level.INFO, "Party created:{0} in DB", party);
                } else {
                    log.log(Level.SEVERE, "Creating party failed:{0} in DB", party);
                    throw new SQLException("Creating party failed, no ID obtained.");
                }
            }
        } catch(SQLException ex){
            log.log(Level.SEVERE, "Creating party:{0} failed in DB", ex);
            throw ex;
        }
        finally {
            DBUtil.close(resultSet);
            DBUtil.close(stmt);
            DBUtil.close(connection);
        }
    }
    
    public List<Party> getAllPartiest() throws SQLException, ParseException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        log.info("Getting all contestent from DB");
        String query = "SELECT * FROM party";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSetToPartyList(resultSet);
        } catch(SQLException ex){
            log.log(Level.SEVERE, "Getting party:{0} failed in DB", ex);
            throw ex;
        }
        finally {
            DBUtil.close(resultSet);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
    }
    
    private List<Party> resultSetToPartyList(ResultSet resultSet) throws SQLException, ParseException {
        List<Party> partyList = new ArrayList();
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            //String picLoc = resultSet.getString("picloc");
            String estDate = resultSet.getString("EstablishedDate");
            int numberOfMembers = resultSet.getInt("NoOfMembers");
            String description = resultSet.getString("description");
            int photoId = resultSet.getInt("photo_id");
               
            // TODO: convert agentList array to real List and use it in constructor
            Party party = new Party();
            party.setId(id);
            
            
            party.setEstablishedDate(dateFormater.parse(estDate));
            party.setName(name);
            party.setNumberOfMembers(numberOfMembers);
            party.setDescription(description);
            party.setPhotoId(photoId);
            partyList.add(party);
        }
        return partyList;
    }
    
}
