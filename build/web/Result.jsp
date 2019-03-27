<%-- 
    Document   : ballot
    Created on : Jul 10, 2016, 12:26:49 AM
    Author     : Shruti Shrestha
--%>


     
     <%@page import="java.sql.SQLException"%>
<%@page import="utils.Database_connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Domain.Voter.Results"%>
<%@page import="java.util.List"%>
<%@page import="Domain.Candidate.Candidate"%>
<%@page import="com.ovp.entities.Commisner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>main</title>
        <link rel="stylesheet" type="text/css" href="styleSheet.css">
         <link rel="stylesheet" href="table/css/reset.css">

    
        <link rel="stylesheet" href="css/table_style.css">
    </head>
    <body>
       
         <%@include file="Header.jsp" %>
        
        <div class="main">
          
               <br>
                              <br>
              
 <section> <!--for demo wrap-->
    <font align="right"> </font>
<h1>RESULT ACCORDING TO PARTY NATION WIDE</h1>
<div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
  <thead>
       
    <tr>
      <th>Party</th>
      <th>Total votes</th>
     
   

     
    </tr>
  </thead>
</table>
</div>
<div  class="tbl-content">
<table cellpadding="0" cellspacing="0" border="0" >
 
              <% 
              List<Results> rPartyList=new ArrayList<Results>();
     try{
         Results rparty=null;
     
              String q="SELECT PARTY, sum(vote) as totvote from candidate group by party ";
              PreparedStatement p=new Database_connection().getPreparedStatement(q);
                   ResultSet rset=p.executeQuery();
           while(rset.next()){
                rparty=new Results();
            rparty.setParty(rset.getString("PARTY"));
            rparty.setSum(rset.getInt("totvote"));
            rPartyList.add(rparty);
           }
     }catch (SQLException e) {
              System.out.print("this is catch");
     }
            for (Results rp:rPartyList){ 
                                int count=0;
                        %>
                      <tr> 
                       <td><%=rp.getParty()%></td>

                      <td><%=rp.getSum()%>
                         
                            <%}%>
                        </tbody></table>
             <br>
                          <br>

                                       <br>
<h1>RESULT ACCORDING TO CANDIDATE</h1>
   <div  class="tbl-header">
<table cellpadding="0" cellspacing="0" border="0">
  <thead>
    <tr>
      <th>Party</th>
      <th>District</th>
      <th>Name</th>
      <th>Value</th>
   

     
    </tr>
  </thead>
</table>
</div>
<div  class="tbl-content">
<table cellpadding="0" cellspacing="0" border="0" id="vote"> 
                            
    
    <%Results r=null;
                List<Results> rList=new ArrayList<Results>();
        try {
            String query="select NAME,PARTY,DISTRICT,VOTE from candidate Order By district";
      
        PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
       
       
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                r=new Results();
            r.setName(rs.getString("NAME"));
            r.setValue(rs.getInt("VOTE"));
            r.setParty(rs.getString("PARTY"));
                        r.setDistrict(rs.getString("DISTRICT"));

           rList.add(r);
            }
        
 } catch (SQLException ex) {
              System.out.print("this is catch");
          }
                                 
          


                            for (Results candidate:rList){ 
                                int count=0;
                        %>
                      <tr> 
                                              
                      <td><%=candidate.getParty()%></td>
                        <td><%=candidate.getDistrict()%></td>

                               <td><%=candidate.getName()%></td>
                                                      <td><%=candidate.getValue()%></td>
                      </tr>
                         
                            <%}%>
                        </tbody></table>
                        <br>
                                                <br>

                                                                        <br>

                                                                                                <br>
</div>
</section>
                              



<!-- follow me template -->

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
</div>
</body>
</html>