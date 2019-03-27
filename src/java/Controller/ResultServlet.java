/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Domain.Admin.Result;
import Domain.Voter.Results;
import Service.ResultService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Database_connection;

/**
 *
 * @author acer
 */
@WebServlet(name = "ResultServlet", urlPatterns = {"/ResultServlet"})
public class ResultServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String  page=request.getParameter("page");
//                  
     if(page.equalsIgnoreCase("map")){
         
   
  RequestDispatcher rd=request.getRequestDispatcher("map.jsp");//code number display
                rd.forward(request, response);   
     
     }    
      
       if(page.equalsIgnoreCase("result")){
     int id=Integer.parseInt(request.getParameter("id"));
     List<Results> rList=new ArrayList<Results>();
     Results r=null;
        try {String query="select party,name,value from tblcandidate ";
      
        PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
       
        System.out.print("2");
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                r=new Results();
            r.setName(rs.getString("name"));
            r.setValue(rs.getInt("value"));
            r.setParty(rs.getString("party"));
           rList.add(r);
            }


          } catch (SQLException ex) {
              System.out.print("this is catch");
          }
         Results rparty=new Results();
        try {
            String query="select* from tblresult ";
      
        PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
        ResultSet rs=pstm.executeQuery();
            while(rs.next()){
               rparty.setValue(rs.getInt("value"));
            rparty.setParty(rs.getString("party"));
         
            }
 } catch (SQLException ex) {
              System.out.print("this is catch");
          }
        request.setAttribute("rList",rList);
          RequestDispatcher rd=request.getRequestDispatcher("Result.jsp");
          rd.forward(request, response);
      }
    
    
      
           
      
       
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  