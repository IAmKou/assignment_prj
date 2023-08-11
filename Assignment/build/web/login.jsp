<%-- 
    Document   : login.jsp
    Created on : Aug 7, 2023, 10:47:56 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="userLoginController" method="post">
            Username: <input type="text" name="username"><br/>
            Password: <input type="password" name="password"><br/>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
