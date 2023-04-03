<%-- Document : login Created on : Oct 29, 2022, 8:43:48 PM Author : user --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="./css/style.css">
                <title>Login</title>
            </head>

            <body>

                <h2>Login Form</h2>

                <form action="login" method="post">
                    <div class="imgcontainer">
                        <img src="images/img_avatar2.png" alt="Avatar" class="avatar">
                    </div>

                    <c:set var="cookie" value="${pageContext.request.cookies}" />

                    <div class="container">
                        <h3 style="color: red"> ${requestScope.ms}</h3>
                        <label for="1"><b>Username</b></label>
                        <input type="text" placeholder="Enter Username" name="1" pattern="[a-zA-z0-9]{4,255}"
                            title="must be at least 8 characters" autocomplete="off" required
                            value="${cookie.cuser.value}" /><br />

                        <label for="2"><b>Password</b></label>
                        <input type="password" placeholder="Enter Password" name="2" pattern="[a-zA-z0-9!#$%^&*]{4,255}"
                            title="must be at least 8 characters" autocomplete="off" required
                                value="${cookie.cpass.value}" /><br />
                        
                                <input type="checkbox" 
                                ${(cookie.crem!=null?'checked':'')} name="3" value="ON"/> Remmember Me<br/>
                         <button type="submit">LOGIN</button>
                    </div>

                </form>

            </body>


            <!-- <body>
            <div>
            <h1>Login Form</h1>
            <div class="imgcontainer">
                <img src="images/img_avatar2.png" alt="" class="avatar">
            </div>
            <h3 style="color: red"> ${requestScope.ms}</h3> 
            <c:set var="cookie" value = "${pageContext.request.cookies}"/>
            <form action="login" method="post" class="modal">
                <div class="container">
                Enter username: <input type="text" name="1" pattern="[a-zA-z0-9]{4,255}" title="must be at least 8 characters" autocomplete="off" required 
                                     value="${cookie.cuser.value}"/><br/>
                Enter password: <input type="password" name="2" pattern="[a-zA-z0-9!#$%^&*]{4,255}" title="must be at least 8 characters" autocomplete="off" required
                                     value="${cookie.cpass.value}"/><br/>
                <input type="checkbox" 
                       ${(cookie.crem!=null?'checked':'')} name="3" value="ON"/> Remmember Me<br/>
                <input type="submit" value="LOGIN"/>

                </div>
            </form>
            </div>
    </body> -->

            </html>