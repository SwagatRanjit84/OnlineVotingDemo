<%-- 
    Document   : CreateAccount
    Created on : May 14, 2016, 5:40:10 AM
    Author     : windows10
--%>

<%@page import="com.ovp.entities.Voter"%>
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
        <script type="text/javascript">
       
    function notify_date(){
        var value;
        var db;
          $.ajax({
              url:'Date.jsp',
              success:function(data){
                    $('.date').html(data);
                  //  db=document.getElementById("db").value;
                    value=document.getElementById("value").value;   
//                 
                      
                     
                    
                },
        complete:function(){
                          if(value>=59){
      window.location.replace("main.jsp");
                        }
                        {
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
                <li ><a href="contestant.jsp"><span class="glyphicon glyphicon-home"></span>&nbsp;Home</a></li>
          
                <li ><a href="addCampaign.jsp"><span class="glyphicon glyphicon-cog"></span>&nbsp;Election Setup</a>
                     <li ><a href="registrationForm.jsp"><span class="glyphicon glyphicon-earphone"></span>&nbsp;Registration</a></li>   
                </li>
                <li><a  href="partyRegistration.jsp"><span class="glyphicon glyphicon-cog"></span>&nbsp; Party Setup</a></li>  
                <li><a  href="addPost.jsp"><span class="glyphicon glyphicon-cog"></span>&nbsp; Post Set Up</a></li>       
                <li ><a href="./CandidateServlet"><span class="glyphicon glyphicon-earphone"></span>&nbsp; Candidate Set up</a></li>
             
          
               
           
           
             
            
           
            <li ><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> &nbsp;Logout</a></li>
         
            </ul>
            
                    </div>
            </div>
  
    </body>
</html>
