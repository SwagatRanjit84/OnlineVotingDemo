<%-- 
    Document   : CreateAccount
    Created on : May 14, 2016, 5:40:10 AM
    Author     : windows10
--%>

<%@page import="Domain.Voter.Voter"%>
<%@page import="javax.faces.bean.SessionScoped"%>
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
        
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
 

    
        

        <script src="bootstrap/js/jquery.js"></script>
        
        <script >
            <%@include file="bootstrap/js/bootstrap.js" %>
        </script>
 <script type="text/javascript">
       
    function notify_date(){
        var value;
        var db;
          $.ajax({
              url:'Date.jsp',
              success:function(data){
                    $('.date').html(data);
                    db=document.getElementById("db").value;
                    value=document.getElementById("value").value;   
//                 
                      
                     
                    
                },
        complete:function(){
                          if(value>=59){
                           document.getElementById('voter').style.display = 'none';
                    document.getElementById('result').style.display = 'block';
                     document.getElementById('time').style.display = 'none';
                    document.getElementById('ftime').style.display = 'block';
                     // document.getElementById("dbi").innerHTML=db;
                    if(db==0)
                    {
                           $.ajax({
                               url:'SetResult.jsp',
                               success:function(data){
                                   $('.date').html(data);
                               }
                           });
                       }
        }
                          else{
                        
                               document.getElementById('result').style.display = 'none';
                    document.getElementById('voter').style.display = 'block';
                     document.getElementById('ftime').style.display = 'none';
                    document.getElementById('time').style.display = 'block';
                     setTimeout(notify_date(),2000);
                 }
                 }
                  });
              }
                            
            
          </script>
   
<style>
            
                ul {
                    list-style-type: none;
                    margin: 0;
                    padding: 0;
                    overflow: hidden;
                    background-color:#12436d;
                    position: fixed;
                    width: 100%;
                } 
                li {
                    float: left;
                    border-right:1px solid #bbb;
                  
                }
                li a {
                    display: block;
                    color: white;
                    text-align: center;
                    padding: 14px 16px;
                    text-decoration: none;
                }
                li a:hover {
                    background-color: #185890;
                }
                li.a:active {
                      background-color:darkorchid;
                }
             .header{margin-right:10px;  padding:none; width:100%; }

            
            .website_name{height:80px; width:100%; margin:auto; background-color:#165083;  position: fixed;
                         padding-top:10px; color:burlywood; text-align:center;}
            .footer{height:90px; width:100%; margin:auto; color:lightgrey; padding-top:5px; padding-bottom:20px;  background-color:darkmagenta; text-align:center;}
            
        </style>
        <title>JSP Page</title>
        
</head>
        
   
<body onload="notify_date()">
      
           
            <div class="header"> 
            <div class="website_name" ><h1>Online voting portal</h1>
    
            <ul class="nav nav-tabs">
               <%
                    boolean unRegisterdUser = true;
                    Commisner verifiedCommisner =(Commisner)session.getAttribute("verifiedCommisner");
                    boolean admin=false;
                    Voter voter =(Voter)session.getAttribute("voter");
                if (verifiedCommisner!= null){
                     admin=true;
                     unRegisterdUser = false;
                } else if(voter != null) {
                   unRegisterdUser = false;
                }
                %>          
                <li><a  href="./DisplayCandidate"></span>&nbsp;Home</a></li> 
           <% 
                if (admin){
           %>
                <li ><a href="addCampaign.jsp"><span class="glyphicon glyphicon-cog"></span>&nbsp;Election Setup</a>
                       
                </li>
                 <li><a href="registrationForm.jsp"><span class="glyphicon glyphicon-log-out"></span> &nbsp;Registration</a></li>
                <li><a  href="partyRegistration.jsp"><span class="glyphicon glyphicon-cog"></span>&nbsp; Party Setup</a></li>  
                <li><a  href="addPost.jsp"><span class="glyphicon glyphicon-cog"></span>&nbsp; Post Set Up</a></li>       
                <li ><a href="./CandidateServlet"><span class="glyphicon glyphicon-earphone"></span>&nbsp; Candidate Set up</a></li>
                
                <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> &nbsp;Logout</a></li>
            <% } else {%>         
           
            <div id="voter"> <li ><a href="home1.jsp"><span class="glyphicon glyphicon-hand-up"></span>&nbsp;Vote</a></li></div>
          <div id="result">    <li ><a href="Result.jsp"><span class="glyphicon glyphicon-hand-up"></span>&nbsp;Result</a></li></div>
                    <div id="votedvoter">    <li ><a href="VotedVoter.jsp"><span class="glyphicon glyphicon-hand-up"></span>&nbsp;Voted Voter List</a></li></div>


            <li ><a href="addContestant.jsp"><span class="glyphicon glyphicon-earphone"></span>&nbsp;Contact</a></li>
            <li ><a href="#about"><span class="glyphicon glyphicon-heart-empty"></span>&nbsp;About Us</a></li>
           <div id="time"> <li style="position:absolute; bottom:10px;right:25px;">Time:  <div class="date"></div></li></div>
                     <div id="ftime">   <li style="position:absolute; bottom:10px;right:25px;">Voting Time Has Already Been Finished</div></li></div>

            
            <% }%>
            </ul>
            </div>
             </div>    
        
            
       
    </body>
</html>
