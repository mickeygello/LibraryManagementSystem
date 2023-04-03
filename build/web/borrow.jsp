<%-- 
    Document   : borrow
    Created on : Nov 1, 2022, 5:57:13 PM
    Author     : user
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrow Book</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <%
        String x = request.getParameter("1");
        %>
        <h2> Borrow Book </h2>
        <form action="borrow" method="POST">
            <p><label> Enter UserName </label> 
                <input type="text" name="1" pattern="[a-zA-z0-9]{1,255}" autocomplete="off" required/>
            <p><label>Enter PassWord </label>  
                <input type="password" name="2" pattern="[a-zA-z0-9!#$%^&*]{1,255}" autocomplete="off" required/>
            <p><label> Book Id </label>  
                <input type="text" name="3" value="<%= x %>" readonly/>
            <p><label> Time Period </label>  
                <select name="4">
                    <% for(int i=1 ; i<31; i++) { %>
                    <option value="<%= i %>"> <%= i %> </option>
                    <% } %>
                </select> day
            <p><input type="submit" value="BORROW" /> 
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
