/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.Voter.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Database_connection;

/**
 *
 * @author Sweychya
 */
public class UserService {
     public List<User> getUserList() {
         List<User> userList=new ArrayList<User>();

        try
        {
            String query="select* from forum";
            PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
             User   user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
            user.setDrink("drink");

             userList.add(user);

            }

        }
catch(SQLException e){
            e.printStackTrace();
        }
return userList;
    }
}
