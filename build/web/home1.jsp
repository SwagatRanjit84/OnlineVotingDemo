<%-- 
    Document   : home
    Created on : Jun 3, 2016, 10:59:14 PM
    Author     : Rashmi Tiwari
--%>

<%@page import="com.ovp.entities.Commisner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="bootstrap/js/jquery.js"></script>

        <script >
            <%@include file="bootstrap/js/bootstrap.js" %>
        </script>
        <link rel="stylesheet" type="text/css" href="style.css">
            </head>
    <body>
        
        <%@include file="Header1.jsp" %>
        <div class="main">
            
            <br>
            <div class="right" >
               <center> ${mnotlogin}<center>
               
               

   
            <form action="vlogin" role="form" method="post">
                  <input type="hidden" name="page" value="VoterForm">
                 
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span>Voter_id</label>
              <input type="text" class="form-control" name="voter_id" placeholder="voter_id">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Citizenship</label>
              <input type="password" class="form-control" name="citizenship" placeholder="Citizenship_no.">
            </div>
            
                   
            
                  
              <button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
          </form>
        
       
         
       
      </div>
       </div>
    </div>
 </div>
            <div class="right2">
                <center> "Ballot is stronger than bullet".<br><br> "your VOTE is your VOICE".<br><br> "If you don't VOTE
                    you lose the right to complain".<br>
                </center> 
            </div>
       
       
    </body>
</html>
