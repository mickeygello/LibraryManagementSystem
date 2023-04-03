<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="dal.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search result</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%
         Book x = (Book) request.getAttribute("x");
         if(x==null) return;
        %>    
        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <h2> Update a Book </h2>
        <form action="book_update" method="POST">
            <p><label>Enter Book ID</label> 
                <input type="text" name="1" value="<%= x.getId()%>" readonly/>

            <p><label>Enter Book Name</label> 
                <input type="text" name="2" value="<%= x.getName()%>" pattern="[A-Za-z0-9 ]{1,255}" title="Name must be [A-Za-z0-9]" autocomplete="off" required/>

            <p><label>Enter Category ID </label>  
                <input type="text" name="3" value="<%= x.getCategoryId()%>" pattern="^([1-9]|1[0-2])$" title="CategoryID must be in range [1,12]" autocomplete="off" required/>

            <p><label>Enter Age Limit </label>  
                <input type="text" name="4" value="<%= x.getAgeLimit()%>" pattern="[0-9]{1,255}" title="AgeLimit must be integer" autocomplete="off" required/>

            <p><label>Enter Number Page </label>  
                <input type="text" name="5" value="<%= x.getNumberPage()%>"   pattern="[0-9]{1,255}" title="NumberPage must be integer" autocomplete="off" required/>

            <p><label>Enter Author </label>  
                <input type="text" name="6" value="<%= x.getAuthor()%>" pattern="[A-Za-z0-9 ]{1,255}" title="Author must be [A-Za-z0-9]" autocomplete="off" required/>    

            <p><label>Enter Publisher </label>  
                <input type="text" name="7" value="<%= x.getPublisher()%>" pattern="[A-Za-z0-9 ]{1,255}" title="Publisher: must be [A-Za-z0-9]" autocomplete="off" required/>    

            <p><label>Enter Publication Date</label> 
                <input type="date" name="8" value="2000-01-01"/>

            <p><label>Available Status:
                    <input type="radio" name="9" value="true" checked="checked"/> True
                    <input type="radio" name="9" value="false" />False

                    <input type="submit" value="UPDATE" /> 
        </form>  <%@include file="footer.jsp" %>
    </body>
</html>
