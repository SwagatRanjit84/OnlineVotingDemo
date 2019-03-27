<%-- 
    Document   : Date
    Created on : Jul 30, 2016, 2:27:56 PM
    Author     : acer
--%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="Controller.ResultServlet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="utils.Database_connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.lang.*"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%Date d = new Date();
        // out.print(d+"\n");
        %>
        <br />
        <%
        String dt=(d.toString());
        String hr=dt.substring(11,19);
                   String h=dt.substring(14,16);


      int hour=Integer.parseInt(h);
        request.setAttribute("hr",hour);
//        if(hour>20){
//        out.println("sakyo");
//        }
//        else{
       
            out.println(hr);
//        }
//         String  query="select* from tblresult ";
//       int a=0;
//            try{PreparedStatement pstm=new Database_connection().getPreparedStatement(query);
//            
//            ResultSet rs=pstm.executeQuery();
//            while(rs.next()){
//              a=1;
//            }
//            }
//        catch (SQLException ex) {
//            Logger.getLogger(ResultServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
// 
//        out.print(a);
//        
//        request.setAttribute("a",a);
        %>
             <input type="hidden" id="db" name="a" value="${a}">

        <input type="hidden" id="value" name="a" value="${hr}">
              

    </body>
</html>
