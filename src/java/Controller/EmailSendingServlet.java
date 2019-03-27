package Controller;

import Domain.Voter.Voter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 * 
 * @author www.codejava.net
 * 
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}
public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);

}
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// reads form fields
                HttpSession session=request.getSession(false); 
		String recipient = (String)session.getAttribute("recipient");
		//String subject = request.getParameter("subject");
		//String content = request.getParameter("content");
                System.out.print("==========>"+recipient);
                               

		String resultMessage =(String)request.getSession().getAttribute("message");
                 System.out.print("==========>"+resultMessage);

		try {
			EmailUtility.sendEmail(host, port, user, pass, recipient,resultMessage);
					                       System.out.print("9");

			resultMessage = "The e-mail was sent successfully";
		} catch (Exception ex) {
                                           System.out.print("11");

			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage();
		} finally {
			request.setAttribute("Message", resultMessage);
                      Voter voter=(Voter) session.getAttribute("voter");
                   if(voter!=null) {
                       System.out.print("10");
			getServletContext().getRequestDispatcher("/SecondPinForm.jsp").forward(
					request, response);
                  
                              }
                   else
                   { getServletContext().getRequestDispatcher("/FirstPinForm.jsp").forward(
					request, response);
                  
                              }
	}
}}