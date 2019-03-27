<%-- 
    Document   : registrationForm
    Created on : Jun 2, 2016, 10:25:23 PM
    Author     : Rashmi Tiwari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="styleSheet.css">
         <script type="text/javascript">
              </script>
    </head>
    <body >
         <%@include file="Header1.jsp" %>
        <div class="main">
            <div class="box1">
            
              
                    <fieldset class="scheduler-border">
                       <center>
		<h3>${sessionScope.voter.name}</h3>
                	



                your pin have succesfully send to your email ... please chek and input
                </center>
               <form method="post" action="fromSpin">
      <input type="hidden" name="page" value="a" >



    <p><input type="text" name="SecondPin" value="" placeholder="#####"></p>
            
            <p class="submit"><input type="submit" name="Login" value="Done"></p>
        </form>
	
                    </fieldset>
                
                    
            </div>   
            
        </div>
                       
    </body>
</html>
