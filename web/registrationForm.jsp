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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="bootstrap/js/jquery.js"></script>

        <script >
            <%@include file="bootstrap/js/bootstrap.js" %>
        </script>
        <link rel="stylesheet" type="text/css" href="styleSheet.css">
         <script type="text/javascript">
             function pig(){
                                     document.getElementById('emailpin').style.display = 'none';
                                    
                                }

                                
  
//   var form=$("#myForm");
//$("#btn1").click(function(){
//$.ajax({
//        type:"POST",
//        url:frm(),
//        data:form.serialize(),
//        success: function(response){
//              document.getElementById('emailpin').style.display = 'block';
//        }
//    });
//});
//                      
                     
                    
                
                            
                        </script>
    </head>
    <body onload="pig()">
         <%@include file="H.jsp" %>
        <div class="main">
            <div class="box1">
            
              
                    <fieldset class="scheduler-border">
                        <legend class="scheduler-border" >Registration:</legend>
                      <form role="form"  method="post" action="submitreg" id="myForm">
                             <input type="hidden" name="page" value="regemail" >
                             <h1>${mes}</h1>
                        <div class="form-group" >
                            <label for="first-name">Name:</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder=" name">
                        </div>
                           <div class="form-group" >
                            <label for="district">District:</label>
                            <input type="text" class="form-control" id="district" name="district" placeholder=" name">
                        </div>
                        
                       
                         
                          <div class="form-group">
                            <label for="ctn">Citizenship No.:</label>
                            <input type="text" class="form-control" id="citizenship" name="citizenship" placeholder="enter your citizenship number">
                        </div>
                        <div class="form-group">
                            <label for="vid">Voter ID:</label>
                            <input type="text" class="form-control" id="voter_id" name="voter_id" placeholder="enter your voter id">
                        </div>
                          <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
                          </div>
                          
                        <button type="submit" id="btn1" class="btn btn-primary" >submit</button>
                        </form>
                        <div class="form-group" id="emailpin">
                       
                    </fieldset>
                
                    
            </div>   
            
        </div>
                       
    </body>
</html>
