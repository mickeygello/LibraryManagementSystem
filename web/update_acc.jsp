<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@page import="dal.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Account</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%
        Account x = (Account) request.getAttribute("x");
         if(x==null) return;
        %>    
        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <h2> Update a Account </h2>
        <form action="acc_update" method="POST">
            <p><label>Enter UserName</label> 
                <input type="text" name="1" value="<%= x.getUsername()%>" readonly/>

            <p><label>Enter PassWord </label>  
                <input type="text" name="2" value="<%= x.getPassword()%>" pattern="[a-zA-z0-9!@#$%^&*]{4,30}" title="PassWord must be at least 8 characters" autocomplete="off" required/>

            <p><label>Enter FirstName </label>  
                <input type="text" name="3" value="<%= x.getFirstName()%>" autocomplete="off" required/>

            <p><label>Enter LastName </label>  
                <input type="text" name="4" value="<%= x.getLastName()%>"   title="UserName must be at least 8 characters" autocomplete="off" required/>

            <p><label>Enter Citizenship Identity </label>  
                <input type="text" name="5" value="<%= x.getCitizenshipIdentity()%>" pattern="[0-9]{12}" autocomplete="off" required/>    

            <p><label>Enter DOB </label>  
                <input type="date" name="6" value="<%= x.getDob()%>" />    

            <p>Gender:
                <input type="radio" checked name="7" value="male" /> Male
                <input type="radio"  name="7" value="female" /> Female

            <p><label>Enter Address</label> 
                <input type="text" name="8" value="<%= x.getAddress()%>" autocomplete="off" required/>

            <p><label>Enter PhoneNumber</label> 
                <input type="text" name="9" value="<%= x.getPhoneNumber()%>" pattern="[0-9]{10}" title="PhoneNumber must be at least 10 numbers" autocomplete="off" required/>

            <p><label>Enter Email</label> 
                <input type="text" name="10" value="<%= x.getEmail()%>" autocomplete="off" required/>

            <p><input type="submit" value="UPDATE" /> 
        </form>  
        <%@include file="footer.jsp" %>
    </body>
</html>
