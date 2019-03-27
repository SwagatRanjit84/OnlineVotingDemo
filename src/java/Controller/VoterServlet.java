/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Domain.Candidate.Candidate;
import Domain.Voter.Forum;
import Domain.Voter.User;
import Domain.Voter.VotedVoter;
import Domain.Voter.Voter;
import Service.CandidateService;
import Service.ForumService;
import Service.UserService;
import Service.VoterService;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "SelectServlet", urlPatterns = {"/SelectServlet"})
public class VoterServlet extends HttpServlet {

 
   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          String page=request.getParameter("page");
          if(page.equalsIgnoreCase("CandidateList"))
          {
                           String district=(String) request.getSession().getAttribute("district");
System.out.println("district"+district);
              List<Candidate> candidateList =(List<Candidate>)new CandidateService().getCandidateList(district);
              request.setAttribute("candidateList",candidateList);
                HttpSession session=request.getSession(false);

            
            
          RequestDispatcher rd=request.getRequestDispatcher("ballot.jsp");
        rd.forward(request,response);
        }

          
          if(page.equalsIgnoreCase("Form"))
          {
              
              int id=(int) request.getSession().getAttribute("id");
             int voter= new VoterService().checkVotedVoter(id);
             if(voter==1){
              String voter_id=(String)request.getSession().getAttribute("voter_id");
             
              System.out.println(voter_id+"-----1");
              new VoterService().setVotedVoter(id,voter_id);
              System.out.println(voter_id+"----3");

              int option=Integer.parseInt(request.getParameter("radioName"));
              new CandidateService().voteIncrease(option);
                         
        RequestDispatcher rd=request.getRequestDispatcher("feedback.jsp");
        rd.forward(request,response);
        }
             else if(voter==0){
                 request.setAttribute("againv", "already voted");
                  RequestDispatcher rd=request.getRequestDispatcher("feedback.jsp");
        rd.forward(request,response);
             }
             
          }

           if(page.equalsIgnoreCase("forum"))
          {
                   List<Forum> forumList =new ForumService().getForumList();
              request.setAttribute("forumList",forumList);
          RequestDispatcher rd=request.getRequestDispatcher("forum.jsp");
        rd.forward(request,response);
          }
             
        if(page.equalsIgnoreCase("VotedList")){   
                    List<VotedVoter> VotedList=   new  VoterService().DisplayVotedVoter();
request.setAttribute("VotedList",VotedList);
       RequestDispatcher rd=request.getRequestDispatcher("VotedList.jsp");
       rd.forward(request,response);
 }
          }
}
          
         

