<%-- 
    Document   : acc_search
    Created on : Oct 30, 2022, 11:16:24 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search account by UserName</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <h3> Search account by UserName </h3>
        <form action="acc_search" method="POST">
            <p><label>Enter UserName</label> 
                <input type="text" name="1" autocomplete="off" required/>
            <p><input type="submit" value="SEARCH" /> 
        </form>  

        <%@include file="footer.jsp" %>
    </body>
</html>
