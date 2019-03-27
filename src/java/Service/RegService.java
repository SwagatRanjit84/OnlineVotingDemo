/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Classes.RandomNumber;
import Classes.e;
import Domain.Candidate.Candidate;
import Domain.Voter.Registration;
import Domain.Voter.Voter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.Database_connection;

/**
 *
 * @author acer
 */
public class RegService {
    public void setReg(String name,String email,String district,String voter_id,String citizenship){
     try
        {
            System.out.print("reg");
            String query="insert into tblvoter(name,email,district,voter_id,citizenship) values(?,?,?,?,?)";
            
            PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, district);
            pstm.setString(4, voter_id);
            pstm.setString(5, citizenship);
            pstm.execute();
                        System.out.print("regafter execute");

            }
catch(SQLException e){
            e.printStackTrace();
        }
    
    }
    
     public void setFirstPin(String email){
       String query="update reg1 set pin=? where email=?";
     try{
RandomNumber rN=new RandomNumber();
         
           int randomNumber= rN.getNumber();
           String rand=e.encrypt(Integer.toString(randomNumber));
         PreparedStatement ps=new Database_connection().getPreparedStatement(query);
               ps.setString(1,rand);
               ps.setString(2,email);
              ps.execute();
        
        }
            catch(Exception e){
                e.printStackTrace();
                
            }
     
     }
     
     public Registration getFirstPin(String email){
          String query="select* from reg1 where email=?";
       Registration  regvoter=null;
       try{ 
           PreparedStatement ps=new Database_connection().getPreparedStatement(query);
       ps.setString(1,email);
    ResultSet rs=ps.executeQuery();
           while(rs.next()){
          regvoter =new Registration();
          
           regvoter.setName(rs.getString("name"));
          
            regvoter.setEmail(rs.getString("email"));
        
                      regvoter.setDistrict(rs.getString("district"));

           regvoter.setVoter_id(rs.getString("voter_id"));
           regvoter.setCitizenship(rs.getString("citizenship"));
         regvoter.setPin(rs.getString("pin"));
         
          
    }
       }
           catch(Exception e){
       e.printStackTrace();
                   }
    return regvoter;
}
      public int checkRegistered(String email,String voter_id,String citizenship){
          int a=0;
     try
        {
            String query="select* from tblvoter where email=? or voter_id=? or citizenship=?";
            
            PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
         
            pstm.setString(1, email);
           
            pstm.setString(2, voter_id);
            pstm.setString(3, citizenship);
            ResultSet rs=pstm.executeQuery();
        while(rs.next()){
        a=1;
        }   
        
        }
catch(SQLException e){
            e.printStackTrace();
        }
    
    return a;
    
      }

  public Registration CheckFirstPin(String oemail,String firstPin){
           String query="select* from reg1 where email=? and pin=? ";
       Registration voter=null;
       try{ 
           PreparedStatement ps=new Database_connection().getPreparedStatement(query);
       ps.setString(1,oemail);
       ps.setString(2, firstPin);
    ResultSet rs=ps.executeQuery();
           while(rs.next()){
          voter =new Registration();
           
           voter.setName(rs.getString("name"));
        //   voter.setRelationName(rs.getString("relationName"));
            voter.setEmail(rs.getString("email"));
          // voter.setPassword(rs.getString("password"));
                      voter.setDistrict(rs.getString("district"));

           voter.setVoter_id(rs.getString("voter_id"));
           voter.setCitizenship(rs.getString("citizenship"));
         voter.setPin(rs.getString("pin"));
           
          
    }
       }
           catch(Exception e){
       e.printStackTrace();
                   }
    return voter;
}

} 

