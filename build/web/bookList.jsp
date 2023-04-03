<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>
<%@page import = "java.util.*" %>

<!DOCTYPE html>
<%
    List<Book> list = (List<Book>) request.getAttribute("book");
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >List of Book</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="menu.jsp" %>
        <h2 align="center"> List of Book </h2>
        <table align="center" border="10">
            <tr>
                <td align="center"> Book Id </td>
                <td align="center"> Book Name </td>
                <td align="center"> Category </td>
                <td align="center"> Age Limit </td>
                <td align="center"> Number Page</td>
                <td align="center"> Author </td>
                <td align="center"> Publisher </td>
                <td align="center"> Publication Date </td>
                <td align="center"> Available Status </td>
                <td align="center"> SignIn to Borrow </td>
            </tr>
            <%
        if(list != null) {
            for(Book x : list) {
            %>
            <tr>
                <td><%= x.getId() %> </td>
                <td><%= x.getName() %> </td>
                <td><%= x.getCategoryId() %> </td>
                <td><%= x.getAgeLimit() %> </td>
                <td><%= x.getNumberPage() %> </td>
                <td><%= x.getAuthor() %> </td>
                <td><%= x.getPublisher() %> </td>
                <td><%= x.getPublicationDate() %> </td>
                <td><%= x.isAvailable() %> </td>
                <td>
                    <% if(x.isAvailable()) { %>
                    <a href="borrow.jsp?1=<%=x.getId() %>"> Borrow </a>
                    <% } else { %>
                    &emsp;&emsp;&emsp;&emsp;&emsp;
                    <a href="return.jsp?1=<%=x.getId() %>"> Return </a>
                    <% } %>
                </td
            </tr>  
            <% } } %>  
        </table>
        <%@include file="footer.jsp" %>
    </body>
</html>
