/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovp.handller;

import com.ovp.dao.CampaignDao;
import com.ovp.dao.ContestentDao;
import com.ovp.dao.ImageDao;
import com.ovp.dao.PartyDao;
import com.ovp.dao.PostDao;
import com.ovp.entities.Campaign;
import com.ovp.entities.Candidate;
import com.ovp.entities.Commisner;
import com.ovp.entities.Party;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Rashmi Tiwari
 */
@WebServlet(name = "CandidateServlet", urlPatterns = {"/CandidateServlet"})
@MultipartConfig(maxFileSize = 16177215)
public class CandidateServlet extends HttpServlet {
    ContestentDao candidateDao =new ContestentDao();
    PartyDao partyDao = new PartyDao();
    PostDao postDao = new PostDao();
    CampaignDao campaignDao = new CampaignDao();
    ImageDao imageDao = new ImageDao();
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name= request.getParameter("name");
            String voterId= request.getParameter("voterID");
            String party= request.getParameter("selectParty");
            int campaingId= Integer.parseInt(request.getParameter("selectCampaign"));
            String post= request.getParameter("selectPost");
            String district=request.getParameter("District");
                
            
            Candidate candidate=new Candidate();
            candidate.setName(name);
            candidate.setId(voterId);
            candidate.setDistrict(district);
            candidate.setParty(party);
            candidate.setPost(post);
            candidate.setCampaignId(campaingId);
           
            InputStream inputStream = null; // input stream of the upload file
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            int imageId = imageDao.InsertImage(inputStream);
            candidate.setPhotoId(imageId);
        }   
            candidateDao.createContestent(candidate);
            response.sendRedirect("./CandidateServlet"); 
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processGetRequest(request, response);
        } catch(SQLException ex) {
            
        } catch ( ParseException ex) {
            
        }
    }

    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<String> posts = postDao.getAllPosts();
            List<Party> parties = partyDao.getAllPartiest();
            List<Campaign> campaigns = campaignDao.getAllCampaign();
            List<Candidate> candidates = candidateDao.getAllCandidate();
            
            request.setAttribute("parties", parties);
            request.setAttribute("campaigns", campaigns);
            request.setAttribute("posts", posts);
           // request.setAttribute("candidates",candidates );
            
            request.getRequestDispatcher("addContestant.jsp").forward(request, response);
           // response.sendRedirect("set_img.jsp");
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
        } catch (SQLException ex) {
            
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
