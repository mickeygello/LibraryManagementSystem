<%-- 
    Document   : return
    Created on : Nov 1, 2022, 9:20:31 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Return Book</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <%
        String x = request.getParameter("1");
        ViolationDAO u = new ViolationDAO();
        List<Violation> lst = u.getAll();
        %>
        <h2> Return Book </h2>
        <form action="return" method="POST">
            <p><label> Enter UserName </label> 
                <input type="text" name="1" pattern="[a-zA-z0-9]{1,255}" autocomplete="off" required/>
            <p><label> Book Id </label>  
                <input type="text" name="2" value="<%= x %>" readonly/>
            <p>Violation 
                <% for(Violation v: lst) { %>
            <p>
                <input type="checkbox" name="3" value="<%= v.getId()%>" /><%= v.getName()%>
                <% } %>

            <p><input type="submit" value="RETURN" /> 
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
