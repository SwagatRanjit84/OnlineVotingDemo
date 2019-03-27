<%-- 
    Document   : partyRegistration
    Created on : Jul 9, 2016, 12:01:01 PM
    Author     : Rashmi Tiwari
--%>

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
        <link rel="stylesheet" type="text/css" href="styleSheet.css">
    </head>
    <body>
         <%@include file="H.jsp" %>
        <div class="main">
            <div class="box1">
                <div>
                    <label><center> Enter Party details below</center></label>
                </div>
            <fieldset class="scheduler-border">
                        <legend class="scheduler-border" >Party:</legend>
                      <form role="form" method="post"  name="formal" action="PartyServlet" enctype="multipart/form-data">
                    
                        <div class="form-group" >
                            <label for="name"> Name:</label>
                            <input type="text" class="form-control" name="name" placeholder="party name" >
                        </div>
                        <div class="form-group">
                             <label for="e_date">Established Date: </label>
                             <input class="form-control"  type="date" name="e_date"  placeholder="Enter party's established date" >
                        </div>
                          
                       <div  class="form-group" id="container">		
                          
                            <label>No. of members:</label>
                            <input class="form-control" name="num_member" type='number'/>
                            <div class="text-justify">
                                 <label>Description:</label>
                                 <textarea class=" form-control "  name="description"></textarea>
                            </div> 
                            
                            
                      </div>
                          <input type="file" name="file" size="50" />
                        <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </fieldset>
        
            </div>
        </div>
    </body>
</html>
