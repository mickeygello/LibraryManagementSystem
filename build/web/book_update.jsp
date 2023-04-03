<!DOCTYPE html>
<html>
    <head>
        <title>Update a Book </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <div style="padding-left: 120px">
            <h2> Update a Book </h2>
            <form action="book_update" method="GET">
                <p>Enter id
                    <input type="text" name="1" value="" placeholder="Enter Book ID"/>
                    <input type="submit" value="UPDATE"/>
            </form>
        </div> 
        <%@include file="footer.jsp" %>
    </body>
</html>
