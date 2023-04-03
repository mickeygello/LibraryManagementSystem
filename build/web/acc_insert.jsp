<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new account</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        
    <%@include file="header.jsp" %>
    <%@include file="menu.jsp" %>
        <div style="padding-left: 120px">
            
        <h3> Create a new account </h3>
        <form action="acc_insert" method="POST">
            <p><label>Enter UserName</label> 
                <input type="text" name="1" pattern="[a-zA-z0-9]{4,255}" title="must be at least 8 characters" autocomplete="off" required/>

            <p><label>Enter PassWord </label>  
                <input type="text" name="2" pattern="[a-zA-z0-9!#$%^&*]{4,255}" title="must be at least 8 characters" autocomplete="off" required/>

            <p><label>Enter FirstName </label>  
                <input type="text" name="3" autocomplete="off" required/>

            <p><label>Enter LastName </label>  
                <input type="text" name="4" autocomplete="off" required/>

            <p><label>Enter Citizenship Identity </label>  
                <input type="text" name="5" pattern="[0-9]{12}" autocomplete="off" required/>    

            <p><label>Enter DOB </label>  
                <input type="date" name="6" value="2000-01-01"/>    

            <p>Gender:
                <input type="radio" name="7" value="male" checked="checked"/> Male
                <input type="radio" name="7" value="female" /> Female

            <p><label>Enter Address</label> 
                <input type="text" name="8" autocomplete="off" required/>

            <p><label>Enter PhoneNumber</label> 
                <input type="text" name="9" pattern="[0-9]{10}" title="must be 10 numbers" autocomplete="off" required/>

            <p><label>Enter Email</label> 
                <input type="text" name="10" autocomplete="off" required/>

            <p><input type="submit" value="Create New Account" /> 
        </form>  

        </div>
    <%@include file="footer.jsp" %>
    </body>
</html>
