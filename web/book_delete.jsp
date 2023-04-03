<%-- 
    Document   : book_delete
    Created on : Oct 30, 2022, 11:18:38 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Delete a Book</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <h2> Delete Book </h2>
        <form action="book_delete" method="POST">
            <p>Enter Book ID
                <input type="text" name="1" placeholder="Enter BookID"/>
                <input type="submit" value="DELETE"/>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>