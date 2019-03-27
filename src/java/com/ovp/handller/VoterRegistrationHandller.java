/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovp.handller;

import com.ovp.dao.VoterDao;
import com.ovp.entities.Voter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Rashmi Tiwari
 */
@WebServlet(name = "VoterRegistrationHandller", urlPatterns = {"/VoterRegistrationHandller"})
public class VoterRegistrationHandller extends HttpServlet {
    private VoterDao vd=new VoterDao();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            String district=request.getParameter("district");
            String birthDate=request.getParameter("dob");
            String citizenshipNum=request.getParameter("citizenshipNum");
            String voterId=request.getParameter("voterId");
            String email=request.getParameter("email");
            
            SimpleDateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd");
            Date dateOfBirth = new Date(dateFormatter.parse(birthDate).getTime());
          
            Voter voter = new Voter();         
            voter.setFirstName(firstName);
            voter.setLastName(lastName);
            voter.setDistrict(district);
            voter.setCitizenshipNum(citizenshipNum);
            voter.setDateOfBirth(dateOfBirth);
            voter.setVoterId(voterId);
            voter.setEmail(email);
            vd.RegisterVoter(voter);
        }
    }

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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(VoterRegistrationHandller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        Logger.getLogger(VoterRegistrationHandller.class.getName()).log(Level.SEVERE, null, ex);
    }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(VoterRegistrationHandller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
        Logger.getLogger(VoterRegistrationHandller.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
