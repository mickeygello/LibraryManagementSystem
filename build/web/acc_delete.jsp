<%-- 
    Document   : acc_delete
    Created on : Oct 30, 2022, 11:17:56 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Delete a Account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
    <%@include file="header.jsp" %>
        <div style="padding-left: 120px">
        <h2> Delete Account </h2>
        <form action="acc_delete" method="POST">
            <p>Enter UserName
                <input type="text" name="1" placeholder="UserName"/>
                <input type="submit" value="DELETE"/>
        </form>
        </div>
    <%@include file="footer.jsp" %>
    </body>
</html>
