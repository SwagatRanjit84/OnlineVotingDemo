package Controller;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Domain.Voter.Forum;
import Domain.Voter.VotedVoter;
import Domain.Voter.Voter;
import Service.ForumService;
import Service.VoterService;
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
 * @author Sweychya
 */
@WebServlet(name = "AjaxServlet", urlPatterns = {"/AjaxServlet"})
public class FeedbackServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    doPost(request,response);
    }

   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
           String page=request.getParameter("page");
            if(page.equalsIgnoreCase("feedback")){  
           RequestDispatcher rd=request.getRequestDispatcher("user/feedback.jsp");
rd.forward(request,response);
            }

            
            
              if(page.equalsIgnoreCase("feedbackSubmit")){  
           RequestDispatcher rd=request.getRequestDispatcher("user/end.jsp");
rd.forward(request,response);

            
            
            }
                    if(page.equalsIgnoreCase("ForumPage")){    
           
               List<Forum> forumList= new ForumService().getForumList();
request.setAttribute("forumList",forumList);
RequestDispatcher rd=request.getRequestDispatcher("user/ForumPage.jsp");
rd.forward(request,response);
            }
 if(page.equalsIgnoreCase("post")){   
     request.setAttribute("feedback","feedback");
     RequestDispatcher rd=request.getRequestDispatcher("user/hehe.jsp");
       rd.forward(request,response);}
 
 
  if(page.equalsIgnoreCase("checkout")){   
     request.setAttribute("feedback"," no feedback");
       RequestDispatcher rd=request.getRequestDispatcher("user/hehe.jsp");
       rd.forward(request,response);
 }
   
    }
}
   
