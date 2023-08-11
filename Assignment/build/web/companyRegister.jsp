<%-- 
    Document   : companyRegister
    Created on : Aug 7, 2023, 10:48:41 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Register Page</title>
    </head>
    <body>
        <form action="companyRegisterController" method="post">
            Company Name: <input type="text" name="cname"><br/><!-- comment -->
            Password: <input type="password" name="password"><br/>
            Confirm Password: <input type="password" name="cfpassword"><br/>
            Email: <input type="text" name="email"><br/>
            Tel: <input type="number" name="phone"><br/>
            Printstream: <select name="printstream">
                     <option value="IT">IT</option>
                     <option value="Mechanical">Mechanical</option>
                     <option value="Agriculture">Agriculture</option>
            </select><br/>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
