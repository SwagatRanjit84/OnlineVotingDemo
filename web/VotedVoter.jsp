<%-- 
    Document   : main
    Created on : Jun 2, 2016, 5:41:01 PM
    Author     : Rashmi Tiwari
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="Domain.Voter.Results"%>
<%@page import="utils.Database_connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.List"%>
<%@page import="Domain.Voter.VotedVoter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ovp.entities.Commisner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>main</title>
        <link rel="stylesheet" type="text/css" href="styleSheet.css">
         <link rel="stylesheet" type="text/css" href="styleSheet.css">
        <link rel="stylesheet" href="table/css/reset.css">

    
        <link rel="stylesheet" href="css/table_style.css">
    </head>
    <body>
       
         <%@include file="Header.jsp" %>
         <% 
       
        boolean readOnly = true;
        if(verifiedCommisner!= null){
            out.println("welcome  "+verifiedCommisner.getUserName());
            readOnly = false;
            
        }
       %>
       
        <div class="main">
            <br>
                        <br>
            <br>

                        <br>

                        
           <h1>List Of The Voters Who Successfully Voted</h1>
   <div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
  <thead>
    <tr>
    <th></th>
      <th>Id of Voted Voter </th>
    
      <th>Time of Vote Polled</th>
   

     
    </tr>
  </thead>
</table>
</div>
<div  class="tbl-content">
<table cellpadding="0" cellspacing="0" border="0" > 
                            
    
    <%
                List<VotedVoter> vvList=new ArrayList<VotedVoter>();
                VotedVoter r=null;
        try {
            String query="select * from votedvoter ";
      
        PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
       ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                r=new VotedVoter();
           
            r.setVoter_id(rs.getString("voter_id"));
            r.setTime(rs.getString("Time"));
                       

           vvList.add(r);
            }
        
 } catch (SQLException x) {
              System.out.print("this is catch");
          }
                                 for (VotedVoter candidate:vvList){ 
                                int count=0;
                        %>
                      <tr> <td></td>
                                                <td><%=candidate.getVoter_id()%></td>


                      <td><%=candidate.getTime()%></td>
                              </tr>
                         
                            <%}%>
                        </tbody>
</table>
                        <br>
                                                <br>

                                                                        <br>

                                                                                                <br>
</div>
                          
        
       
      
                
                    
            </div>    
        </div>
        
    </body>
</html>
