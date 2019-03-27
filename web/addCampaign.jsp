<%-- 
    Document   : main
    Created on : Jun 2, 2016, 5:41:01 PM
    Author     : Rashmi Tiwari
--%>

<%@page import="com.ovp.entities.Commisner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>main</title>
        <link rel="stylesheet" type="text/css" href="styleSheet.css">
    </head>
    <body>
         <%@include file="H.jsp" %>
         <% 
       
        boolean readOnly = true;
        if(verifiedCommisner!= null){
            out.println("welcome  "+verifiedCommisner.getUserName());
            readOnly = false;
            
        }
       %>
       
        <div class="main">
            <div class="box1">
             
                    <fieldset class="scheduler-border">
                        <legend class="scheduler-border" >  campaign:</legend>
                      <form role="form" method="post"  action="CampaignServlet">
                        <div class="form-group" >
                            <label for="title">Title:</label>
                            <input class="form-control" name = "title" id="title">
                        </div>
                        <div class="form-group" >
                            <label for="start-date">Start date:</label>
                            <input type="date" class="form-control" name = "startDate" id="start-date">
                        </div>
                          
                        <div class="form-group">
                             <label for="endDate">End Date:</label>
                             <input class="form-control"  name = "endDate" type="date" id="endDate">
                         </div>
                          <div class="form-group" >
                            <label for="start-Time">Start Time:</label>
                            <input type="time" name = "startTime" class="form-control" id="start-Time" value="" >
                        </div>
                          
                        <div class="form-group">
                             <label for="endTime">End Time:</label>
                             <input name = "endTime" class="form-control"  type="time" id="endTime" value="">
                         </div>
                        
                        <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </fieldset> 
                    
            </div>    
        </div>
        
    </body>
</html>
