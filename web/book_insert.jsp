
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<%
  CategoryDAO u = new CategoryDAO();
  List<Category> lst = u.getAll();
%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD BOOK</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <h3>Add a new book</h3>
        <form action="insertBook" method="POST">
            <p>Book ID: <input type="text" name="1" pattern="[0-9]{1,255}" title="Id must be [0-9]" autocomplete="off" required/>

            <p>Book Name: <input type="text" name="2" pattern="[A-Za-z0-9 ]{1,255}" title="Name must be [A-Za-z0-9]" autocomplete="off" required/>

            <p>Category: 
                <select name="3">
                    <% for(Category x: lst) { %>
                    <option value="<%= x.getId() %>"> <%= x.getName() %> </option>
                    <% } %>
                </select>
            <p>

            <p>Age Limit: <input type="text" name="4" pattern="[0-9]{1,255}" title="AgeLimit must be integer" autocomplete="off" required/>   

            <p>Number Page: <input type="text" name="5" pattern="[0-9]{1,255}" title="NumberPage must be integer" autocomplete="off" required/>    

            <p>Author: <input type="text" name="6" pattern="[A-Za-z0-9 ]{1,255}" title="Author must be [A-Za-z0-9]" autocomplete="off" required/>    

            <p>Publisher: <input type="text" name="7" pattern="[A-Za-z0-9 ]{1,255}" title="Publisher: must be [A-Za-z0-9]" autocomplete="off" required/>    

            <p>Publication Date: <input type="date" name="8" value="2000-01-01"/>
            <p><input type="submit" value="ADD" /> 
        </form>  
        <%@include file="footer.jsp" %>
    </body>
</html>
