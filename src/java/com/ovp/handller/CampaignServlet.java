/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovp.handller;

import com.ovp.dao.CampaignDao;
import com.ovp.entities.Campaign;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rashmi Tiwari
 */
@WebServlet(name = "CampaignServlet", urlPatterns = {"/CampaignServlet"})
public class CampaignServlet extends HttpServlet {
    private CampaignDao campaignDao = new CampaignDao();
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
            String title= request.getParameter("title");
            String sDate= request.getParameter("startDate");
            String eDate= request.getParameter("endDate");
            String sTime= request.getParameter("startTime");
            String eTime= request.getParameter("endTime");
            
            SimpleDateFormat dateFormatter = new SimpleDateFormat("YYYY-MM-dd");
            Date startDate = new Date(dateFormatter.parse(sDate).getTime());
            Date endDate = new Date(dateFormatter.parse(eDate).getTime());
            
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            Time startTime = new Time(formatter.parse(sTime).getTime());
            Time endTime = new Time(formatter.parse(eTime).getTime());
            
           Campaign c = new Campaign(title, startDate, endDate, startTime, endTime);
           campaignDao.createCampaign(c);
            response.sendRedirect("addCampaign.jsp");
            
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
            Logger.getLogger(PartyServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PartyServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CampaignServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CampaignServlet.class.getName()).log(Level.SEVERE, null, ex);
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
