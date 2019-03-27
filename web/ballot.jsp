<%-- 
    Document   : ballot
    Created on : Jul 10, 2016, 12:26:49 AM
    Author     : Shruti Shrestha
--%>


     
     <%@page import="java.util.List"%>
<%@page import="Domain.Candidate.Candidate"%>
<%@page import="com.ovp.entities.Commisner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>main</title>
        <link rel="stylesheet" type="text/css" href="styleSheet.css">
        <link rel="stylesheet" href="table/css/reset.css">

    
        <link rel="stylesheet" href="css/table_style.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>

        <script>
            $(document).ready(function() {
      $("#vote input:radio").click(function() {
var name=document.getElementById("name").value;

           alert("are you sure to vote "+name);

      });

//      $("input:radio:first").prop("checked", true).trigger("click");

});

            
        </script>
    </head>
    

    <body>
       
   <%@include file="Header1.jsp" %>
       <div class="main">
          
               <br>
                              <br>
               <br>

                              <br>

                              
                <h1>Candidates  <span>of</span> ${sessionScope.voter.district} District</span></h1>
 <section> <!--for demo wrap-->
    <font align="right"> <div class="result1"></div></font>

<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
  <thead>
    <tr>
      <th>NAME</th>
      <th>LOGO</th>
      <th>PARTY</th>
      <th>VOTE</th>

     
    </tr>
  </thead>
</table>
</div>
<div  class="tbl-content">
<table cellpadding="0" cellspacing="0" border="0" id="vote">
   <form action="submit" method="post">
              <% 
                                
                  List<Candidate> candidateList = (List<Candidate>)request.getAttribute("candidateList");


                            for (Candidate candidate: candidateList){ 
                                int count=0;
                        %>
                            

                        <tr> 
                            
                            <input type="hidden" id="name" value="<%=candidate.getName()%>">
                           <td><%=candidate.getName()%></td>
                                   
                            <td><%=candidate.getLogo()%></td>
                           <td><%=candidate.getParty()%></td>
                        
                       
                          <input type="hidden" name="page" value="Form">
                          <input type="hidden" id="name" value="<%=candidate.getName()%>">
                         <td> <input type="radio" name="radioName"  value="<%=candidate.getId()%>" /></td>
                           
                            
                            </tr>
                         
                            <%}%>
                        </tbody></table>
                        <br>
                                                <br>

                                                                        <br>

                                                                                                <br>

                       <center> <input type="submit" value="submit"></center>
                                                    </form>

</div>
</section>


<!-- follow me template -->

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
</div>
</body>
</html>