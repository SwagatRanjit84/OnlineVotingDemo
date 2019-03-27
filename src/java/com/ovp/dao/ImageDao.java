/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovp.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.stream.Stream;

/**
 *
 * @author Rashmi Tiwari
 */
public class ImageDao {
    private final static Logger log = Logger.getLogger("PostDao");
    
    public Integer InsertImage( InputStream stream)throws SQLException{
        
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        log.log(Level.INFO, "Creating image:{0} in DB", stream);
        String insertQuery = "INSERT INTO image(photo) VALUES(?)";
        try {
            connection = ConnectionFactory.getConnection();
            stmt = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setBlob(1, stream);
            
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                   log.log(Level.SEVERE, "Creating post: failed in DB");
                throw new SQLException("Creating party failed, no rows affected.");
            }
            // get primary key of the inserted row
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    log.log(Level.INFO, "image created: in DB");
                    return Integer.valueOf(generatedKeys.getString(1));
                    
                } else {
                    log.log(Level.SEVERE, "Creating image failed:\\ in DB");
                    throw new SQLException("Creating image failed, no ID obtained.");
                }
            }
        } catch(SQLException ex){
            log.log(Level.SEVERE, "Creating post:{0} failed in DB", ex);
            return null;
        }
        finally {
            DBUtil.close(resultSet);
            DBUtil.close(stmt);
            DBUtil.close(connection);
        }
    }
    
    public  byte[] getImageById(int imageId) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
       
        String query = "SELECT * FROM image where id ="+ imageId;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            List<byte[]> lists =  resultSetToPostList(resultSet);
            if (lists.isEmpty()) {
                return null;
            } else {
                return lists.get(0);
            }
        } finally {
            DBUtil.close(resultSet);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
    }
    
    private List<byte[]> resultSetToPostList(ResultSet resultSet) throws SQLException {
        List<byte[]> postList = new ArrayList();
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            byte[] bytes = resultSet.getBytes("photo");
            postList.add(bytes);
        }
        return postList;
    }
}
