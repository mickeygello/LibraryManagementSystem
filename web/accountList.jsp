<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>
<%@page import = "java.util.*" %>

<!DOCTYPE html>
<%
  List<Account> list = (List<Account>) request.getAttribute("account");
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/style.css">
        <title>List of Account</title>
    </head>
    <body>

        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <!---------------------------------------------------------------------------------------------->

        <h2 align="center"> List of Account </h2>
        <table align="center" border="10" >
            <tr>
                <td align="center"> Id </td>
                <td align="center"> User Name </td>
                <td align="center"> First Name </td>
                <td align="center"> Last Name </td>
                <td align="center"> Gender </td>
                <td align="center"> Citizenship Identity </td>
                <td align="center"> Date of birth </td>
                <td align="center"> Address </td>
                <td align="center"> Phone Number </td>
                <td align="center"> Email </td>
            </tr>
            <%
        if(list != null) {
            for(Account x : list) {
            %>
            <tr>
                <td><%= x.getId() %> </td>
                <td><%= x.getUsername() %> </td>
                <td><%= x.getFirstName() %> </td>
                <td><%= x.getLastName() %> </td>
                <td><%= x.isGender() %> </td>
                <td><%= x.getCitizenshipIdentity() %> </td>
                <td><%= x.getDob() %> </td>
                <td><%= x.getAddress() %> </td>
                <td><%= x.getPhoneNumber() %> </td>
                <td><%= x.getEmail() %> </td>
            </tr>  
            <% } } %>  
        </table>

        <!---------------------------------------------------------------------------------------------->

        <%@include file="footer.jsp" %>

    </body>
</html>
