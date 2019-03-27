<%-- 
    Document   : contestent
    Created on : Jun 25, 2016, 9:09:50 PM
    Author     : Rashmi Tiwari
--%>

<%@page import="com.ovp.dao.ContestentDao"%>
<%@page import="java.util.List"%>
<%@page import="com.ovp.entities.Candidate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    /* Remove the navbar's default margin-bottom and rounded borders */
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>
     <%@include file="Header.jsp" %>

     
     <% 
      ContestentDao candidateDao = new ContestentDao();
     List<Candidate> candidates = candidateDao.getAllCandidate();
               request.setAttribute("candidates", candidates);
           
           System.out.println("upto here");
     %>
   
<div class="jumbotron">
  <div class="container text-center">
    
  </div>
</div>
  
<div class="container-fluid bg-3 text-center">
  <h3>List of candidate</h3><br>
  <div class="row">
    <c:forEach var="candidate" items="${candidates}">
       <div class="col-sm-3">
           <center>
        <img src="./ImageServlet?image_id=${candidate.photoId}" class="img-responsive" style="width:200px;height:200px;" alt="Image">
        <p>Name:${candidate.name}<br>
        Party:${candidate.party}<br>
        Post:${candidate.post}</p><br>
  
           </center> 
        </div>
    </c:forEach>  
    
  </div>
</div>





   
</body>
</html>