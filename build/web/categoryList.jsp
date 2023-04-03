<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>
<%@page import = "java.util.*" %>

<!DOCTYPE html>
<%
  CategoryDAO u = new CategoryDAO();
  List<Category> list = u.getAll();
  request.setAttribute("category", list);
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >List of Category</title>
           <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
    <%@include file="header.jsp" %>
   <%@include file="menu.jsp" %>
        <h2 align="center"> List of Category </h2>
        <table align="center" border="10">
            <tr>
                <td align="center"> Category Id </td>
                <td align="center"> Category Name </td>
            </tr>
            <%
        if(list != null) {
            for(Category x : list) {
            %>
            <tr>
                <td><%= x.getId() %> </td>
                <td><%= x.getName() %> </td>
            </tr>  
            <% } } %>  
        </table>    
    <%@include file="footer.jsp" %>
    </body>
</html>
