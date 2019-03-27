<%-- 
    Document   : feedback
    Created on : Jul 26, 2016, 9:03:20 AM
    Author     : acer
--%>

   <%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>main</title>
        <link rel="stylesheet" type="text/css" href="styleSheet.css">
        <link rel="stylesheet" href="table/css/reset.css">
        <link rel="stylesheet" type="text/css" href="styleSheet.css">

    
        <link rel="stylesheet" href="css/table_style.css">
        <script>
            $(document).ready(function() {
      $("#vote").click(function() {

           alert("clicked");

      });

//      $("input:radio:first").prop("checked", true).trigger("click");

});

            
        </script>
    </head>
    

    <body>
       
   <%@include file="Header1.jsp" %>
    <br>
    <br>
    <br>
    <br>
      <div class="main">
        <center> 
            <form><h1 style="color:RED">${againv}</h1></form></center>
          <br>
            <center>We appretiate your decision while choosing the candidate.</center>
            <center>Your selection is what values the most.</center>           <br>
            
         <br>
         <center>You can verify if your vote has been accepted or not by viewing the <Strong>Voted Voter List</Strong> available in the homepage to confirm your vote whether it has been counted or not</center> 
         <br>
         <center>
             If in case your voter id is not mentioned then you can login into the system again . But if your voter_id is present there then your vote has been successfuly counted and then you are not able to login into the system again.Results will be shown as soon as the voting finishes.</center>
         
         <center>Thank you !!</center> 
             
         </br>
      </div>  
         
    </body>
</html>
