/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.e;
import Domain.Admin.Admin;
import Domain.Candidate.Candidate;
import Domain.Voter.Voter;
import Service.Admin.AdminService;
import Service.CandidateService;
import Service.ResultService;
import Service.VoterService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page=request.getParameter("page");
        
      
             if(page.equalsIgnoreCase("VoterLogin"))
      {
                   RequestDispatcher rd=request.getRequestDispatcher("VoterLogin.jsp");
                 rd.forward(request, response);
      }
          if(page.equalsIgnoreCase("email1")){
                
   
                 HttpSession session=request.getSession(false);
                String vemail=request.getParameter("email");
                 
                 session.setAttribute("recipient",vemail);
                request.setAttribute("email",vemail);
               
                 RequestDispatcher rd=request.getRequestDispatcher("yo.jsp");//code number display
                rd.forward(request, response);
//             RequestDispatcher rd=request.getRequestDispatcher("/EmailSendingServlet");//code number display
//                rd.forward(request, response);
                        }
      
        
        
       
        
        
       
        if(page.equalsIgnoreCase("VoterForm")){
      
       
        String voter_id=request.getParameter("voter_id");
        String citizenship=request.getParameter("citizenship");
    

        
        Voter voter=new VoterService().getVoter(voter_id,citizenship);
        System.out.print("1");
        if(voter!=null){
             HttpSession session=request.getSession(false);
            session.setAttribute("voter",voter);
            int id=voter.getId();
            String voterI_id=voter.getVoter_id();
                   int  VoterCheck=new VoterService().checkVotedVoter(id);
                   if(VoterCheck==1){
                       
                   System.out.print("3");
            String district=voter.getDistrict();
            
            session.setAttribute("district",district);
            session.setAttribute("voter_id",voterI_id);
            session.setAttribute("id",id);
        new VoterService().setSecondPin(id);//encrypt into table
           Voter v=new VoterService().getSecondPin(id);//receiving ass along with spin in variables
           
           String secondPin=v.getSecondPin();//taking secondPin from program variables
           System.out.println("4");
           if(secondPin!=null){
                   try{  
                       System.out.print("8");
                       String decryptSecPin=e.decrypt(secondPin);//decrypting secondPin
                       System.out.println("decryptsecpin"+decryptSecPin);
                      session.setAttribute("message",decryptSecPin);
                session.setAttribute("VoterCheck",VoterCheck);
                   String ReceiptEmail=voter.getEmail();
                    session.setAttribute("id",id);
                                      
       
                session.setAttribute("recipient",ReceiptEmail);
                
             RequestDispatcher rd=request.getRequestDispatcher("EmailSendingServlet");//code number display
                rd.forward(request, response);
                        }
                      
                   catch(Exception e){
                   e.printStackTrace();
                   }
            } 
            else{
                            request.setAttribute("spin",".....");
                            RequestDispatcher rd=request.getRequestDispatcher("emailpin.jsp");//code number display
                            rd.forward(request, response);
                        }
    }
                   else{
                       request.setAttribute("mnotlogin","already voted");
                    RequestDispatcher rd=request.getRequestDispatcher("home.jsp");//code number display
                            rd.forward(request, response);
                   }
        }
       
        else{
            System.out.print("5");
            request.setAttribute("mnotlogin","login unsuccessful .You arenot registered");
             RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
        }
        
        }       
//        else{
//                        new ResultService().setResultDatabase();
//            request.setAttribute("time","1");
//             RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
//        rd.forward(request, response);
//        }

  
        
      if(page.equalsIgnoreCase("a"))
          {
              String dsecondpin=request.getParameter("SecondPin");//real value from form
               try{
              int id=(int) request.getSession().getAttribute("id");
                String secondPin=e.encrypt(dsecondpin);//encrypt real 
                Voter voter=new VoterService().CheckSecondPin(id,secondPin);
              if(voter!=null){
                   
                           String district=(String) request.getSession().getAttribute("district");
System.out.println("district"+district);
              List<Candidate> candidateList =(List<Candidate>)new CandidateService().getCandidateList(district);
              request.setAttribute("candidateList",candidateList);
               HttpSession session=request.getSession(false);
         
         
          RequestDispatcher rd=request.getRequestDispatcher("ballot.jsp");
        rd.forward(request,response);}
          
          
        

                  
             else{
                  request.setAttribute("message","your code is wrong .please verify it again in your email .");
                  RequestDispatcher rd=request.getRequestDispatcher("SecondPinForm.jsp");
                  rd.forward(request, response);
                }
           }
          catch (Exception ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
          
      
        if(page.equalsIgnoreCase("SecondPinForm")){
             RequestDispatcher rd=request.getRequestDispatcher("SecondPinForm.jsp");
                    rd.forward(request, response);
            }
    }
}
   
    
    
   