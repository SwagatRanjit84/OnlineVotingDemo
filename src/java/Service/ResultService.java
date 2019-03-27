/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Controller.ResultServlet;
import Domain.Admin.Result;
import Domain.Voter.Forum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Database_connection;

/**
 *
 * @author acer
 */
public class ResultService {
      public List<Result> getResultList( int page) {
                  List<Result> resultList=new ArrayList<Result>();

        try {
            
          
            String  query="select* from result where d_id=?";
            PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
            pstm.setInt(1,page);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
               Result res=new Result();
                res.setId(rs.getInt("id"));
                res.setCandidate(rs.getString("candidate"));
                res.setNumberOfVotes(rs.getString("numberOfVotes") );
                 resultList.add(res);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return resultList;
    }
      public void setResultDatabase(){
      String query="insert into tblresult(party,value) select party,sum(value) from tblcandidate  group by party ";
        PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
          
          try {
              pstm.execute();
                            System.out.print("this is try");

          } catch (SQLException ex) {
              System.out.print("this is catch");
          }
           
      }
    
     
      }

