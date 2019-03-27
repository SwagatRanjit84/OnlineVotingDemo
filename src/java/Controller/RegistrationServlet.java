/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.RandomNumber;
import Classes.e;
import Domain.Voter.Forum;
import Domain.Voter.Registration;
import Domain.Voter.Voter;
import Domain.Voter.regEmail;
import Service.ForumService;
import Service.RegService;
import Service.VoterService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {

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
 if(page.equalsIgnoreCase("regemail")){
      
       
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String district=request.getParameter("district");
       String voter_id=request.getParameter("voter_id");
        String citizenship=request.getParameter("citizenship");


                System.out.println("========"+name);
                                System.out.println(email);

                                                System.out.println(district);
                System.out.println(voter_id);
                System.out.println(citizenship);
           
                int  RegistrationCheck=new RegService().checkRegistered(email,voter_id,citizenship);
                  if(RegistrationCheck==0){
                       
                 
//                session.setAttribute("RegistrationCheck",RegistrationCheck);                        
        
      new  RegService().setReg(name,email,district,voter_id,citizenship);
       HttpSession session=request.getSession(false);
                        session.setAttribute("mes","successful registered");
        RequestDispatcher rd=request.getRequestDispatcher("registrationForm.jsp");//code number display
                rd.forward(request, response);
                  }else{
                      HttpSession session=request.getSession(false);
                        session.setAttribute("mes","already registered");
                   RequestDispatcher rd=request.getRequestDispatcher("registrationForm.jsp");//code number display
                rd.forward(request, response);
                  }
//                       
//         HttpSession session=request.getSession(false);
//         session.setAttribute("recipient",email);
//              
//                    
//                   int  RegistrationCheck=new RegService().checkRegistered(email,voter_id,citizenship);
//                   if(RegistrationCheck==0){
//                       
         
//          new RegService().setFirstPin(email);//encrypt into table
//           Registration reg=new RegService().getFirstPin(email);//receiving ass along with spin in variables
//           String regPin=reg.getPin();//taking secondPin from program variables
//            if(regPin!=null){
//                   try{  
//                       String decryptRegPin=e.decrypt(regPin);//decrypting secondPin
//                       session.setAttribute("message",decryptRegPin);
//                session.setAttribute("RegistrationCheck",RegistrationCheck);
//                   String ReceiptEmail=email;
//                    session.setAttribute("email",email);
//                                      
//       
//                session.setAttribute("recipient",ReceiptEmail);
//                System.out.println("1");
//           
//                       RequestDispatcher rd=request.getRequestDispatcher("main.jsp");//code number display
//                rd.forward(request, response);
                      
                
                   
//                   catch(Exception e){
//                   System.out.print("error in email");
//                   }
//                   
//            }
//                   }
//                   else{
//                       request.setAttribute("mes","already been registered");
                        RequestDispatcher rd=request.getRequestDispatcher("registrationForm.jsp");//code number display
                rd.forward(request, response);
                        }
                       
                   
 
 if(page.equalsIgnoreCase("emailpin1"))
          {
              String dfirstpin=request.getParameter("pin");//real value from form
               try{
                String oemail=(String)request.getSession().getAttribute("recipient");
                String firstPin=e.encrypt(dfirstpin);//encrypt real 
                Registration rvoter=new RegService().CheckFirstPin(oemail,firstPin);
              if(rvoter!=null){
                  new VoterService().addVoter(oemail) ;
                   request.setAttribute("mes","Congratulations !! You have been successfully registered");
                RequestDispatcher rd=request.getRequestDispatcher("successfulreg.jsp");
                rd.forward(request, response);
             }else{
                  request.setAttribute("mesemail1","wrong code ");
                  RequestDispatcher rd=request.getRequestDispatcher("FirstPinForm.jsp");
                  rd.forward(request, response);
                }
           }
          catch (Exception ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 
    }    
    }
      
             
        
    

  
 

