/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Admin;

import Domain.Admin.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.Database_connection;

/**
 *
 * @author acer
 */
public class AdminService {
    public Admin getAdmin(String name,String password){
       String query="select* from tbladmin where name=? and password=? ";
       Admin admin=null;
       try{ 
           PreparedStatement ps=new Database_connection().getPreparedStatement(query);
       ps.setString(1,name);
       ps.setString(2,password);
       

           ResultSet rs=ps.executeQuery();
           while(rs.next()){
          admin =new Admin();
           admin.setId(rs.getInt("id"));
           admin.setName(rs.getString("name"));
           admin.setPassword(rs.getString("password"));
          
           
                      

          
         break;
           }
       
    }
       catch(SQLException e){
           e.printStackTrace();
       }
       return admin;
    }
}
