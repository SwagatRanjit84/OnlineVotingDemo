/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.admin;

import Domain.Candidate.Candidate;
import Service.CandidateService;
import Service.ResultService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acer
 */
@WebServlet(name = "AdminiServlet", urlPatterns = {"/AdminiServlet"})
public class AdminiServlet extends HttpServlet {

    
        
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           
          String page=request.getParameter("page");
          if(page.equalsIgnoreCase("CandidateList"))
          {
              List<Candidate> candidateList =(List<Candidate>)new CandidateService().getCandidateList();
              request.setAttribute("candidateList",candidateList);
          RequestDispatcher rd=request.getRequestDispatcher("Voter/CandidateList.jsp");
        rd.forward(request,response);
        }

          
          if(page.equalsIgnoreCase("AddCandidate"))
          {
            RequestDispatcher rd=request.getRequestDispatcher("admin/AddCandidate.jsp");
            rd.forward(request,response);
        }
          
           if(page.equalsIgnoreCase("AddCandidateForm"))
          {
            RequestDispatcher rd=request.getRequestDispatcher("admin/AddCandidate.jsp");
            rd.forward(request,response);
        }
             if(page.equalsIgnoreCase("AddCandidateForm"))
          {
            RequestDispatcher rd=request.getRequestDispatcher("admin/AddCandidate.jsp");
            rd.forward(request,response);
        }
             if(page.equalsIgnoreCase("result")){
              RequestDispatcher rd=request.getRequestDispatcher("map.jsp");
            rd.forward(request,response);
                 }
    
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
   
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
     