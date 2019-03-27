/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.Candidate.Candidate;
import Domain.Voter.Voter;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import utils.Database_connection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Sweychya
 */
public class CandidateService {
    public List<Candidate> getCandidateList() {
        List<Candidate> candidateList=new ArrayList<Candidate>();
        try
        {
            String query="select* from candidate ";
            PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                Candidate candidate=new Candidate();
                candidate.setId(rs.getInt("id"));
                candidate.setName(rs.getString("NAME"));
             candidate.setParty(rs.getString("PARTY") );
             candidate.setDistrict(rs.getString("DISTRICT") );


              candidateList.add(candidate);

            }

        }
catch(SQLException e){
            e.printStackTrace();
        }
return candidateList;
    }
  
    public List<Candidate> getCandidateList(String district) {
        List<Candidate> candidateList=new ArrayList<Candidate>();
        try
        {
            String query="select* from candidate where DISTRICT=?";
            System.out.print ("d====>"+district);
            PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
            pstm.setString(1,district);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                Candidate candidate=new Candidate();
                candidate.setId(rs.getInt("id"));
                candidate.setName(rs.getString("NAME"));
             candidate.setParty(rs.getString("PARTY") );
             candidate.setDistrict(rs.getString("DISTRICT") );


              candidateList.add(candidate);

            }

        }
catch(SQLException e){
            e.printStackTrace();
        }
return candidateList;
    }
    public void voteIncrease(int option){
    String query="update  candidate set VOTE=VOTE+1 where id=?";
    try{PreparedStatement ps=new Database_connection().getPreparedStatement(query);
    ps.setInt(1,option);
    ps.execute();
    System.out.println("data updated");
    
    }
    catch(SQLException e){
        e.printStackTrace();
    }}
}