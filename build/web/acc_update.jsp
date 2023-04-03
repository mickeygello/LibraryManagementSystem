<!DOCTYPE html>
<html>
    <head>
        <title>Update a Account </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <div style="padding-left: 120px">
            <h2> Update a Account </h2>
            <form action="acc_update" method="GET">
                <p>Enter User Name
                    <input type="text" name="1"/>
                    <input type="submit" value="UPDATE"/>
            </form>
        </div> 
        <%@include file="footer.jsp" %>
    </body>
</html>
