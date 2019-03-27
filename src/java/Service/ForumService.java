/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.Candidate.Candidate;
import Domain.Voter.Forum;
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
public class ForumService {
     public List<Forum> getForumList() {
        List<Forum> forumList=new ArrayList<Forum>();

        try
        {
            String query="select* from forum";
            PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                Forum forum=new Forum();
                forum.setId(rs.getInt("id"));
                forum.setCandidate(rs.getString("candidate"));
             forum.setWish(rs.getString("wish") );


              forumList.add(forum);

            }

        }
catch(SQLException e){
            e.printStackTrace();
        }
return forumList;
    }
      public void setForum(String candidate,String wish) {
        Forum forum=new Forum();

        try
        {
            String query="insert into forum(candidate,wish) values(?,?)";
            PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
            pstm.setString(1,candidate);
            pstm.setString(2,wish);
            pstm.execute();
          
      
            }
catch(SQLException e){
            e.printStackTrace();
        }
 }
}
