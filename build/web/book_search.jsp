<%-- 
    Document   : book_search
    Created on : Oct 30, 2022, 11:19:32 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Book by Name</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
           <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
    <%@include file="header.jsp" %>
   <%@include file="menu.jsp" %>
        <h3> Search Book by Name </h3>
        <form action="book_search" method="POST">
            <p><label>Enter Book Name</label> 
                <input type="text" name="1" autocomplete="off" required/>
            <input type="submit" value="SEARCH" /> 
        </form>  
        
        <p><button onclick='window.history.go(-1);'>Back to previous page</button>
            <button onclick='window.location.href = "index.html"'>Back to home page</button>
    <%@include file="footer.jsp" %>
    </body>
</html>
