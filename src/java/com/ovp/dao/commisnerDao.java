/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovp.dao;

import com.ovp.entities.Commisner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rashmi Tiwari
 */
public class commisnerDao {
    
     public Commisner verifyCommisner(Commisner commisner){
        try{
            Connection connection=ConnectionFactory.getConnection();
            String qry="select * from commisner where userName=? and password=?";
            PreparedStatement pst=connection.prepareStatement(qry);
            pst.setString(1, commisner.getUserName());
            pst.setString(2, commisner.getPassword());
            ResultSet rs =pst.executeQuery();
            while(rs.next()){
              Commisner verifiedCommisner = new Commisner(); 
              verifiedCommisner.setUserId(rs.getInt("userId"));
              verifiedCommisner.setUserName(rs.getString("userName"));
              verifiedCommisner.setPassword(rs.getString("password"));
              return verifiedCommisner;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
