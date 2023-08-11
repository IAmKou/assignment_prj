<%-- 
    Document   : register.jsp
    Created on : Aug 7, 2023, 10:48:10 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <form action="registerController" method="post">
            Username: <input type="text" name="username"><br/><!-- comment -->
            Password: <input type="password" name="password"><br/>
            Confirm Password: <input type="password" name="cfpassword"><br/>
            Email: <input type="text" name="email"><br/>
            DoB: <input type="date" name="dob"><br/>
            Phone number: <input type="number" name="phone"><br/>
            Gender: <input type="radio" id="male" name="gender" value="Male">
                    <label for="male">Male</label>
                    <input type="radio" id="female" name="gender" value="Female">
                    <label for="female">Female</label><br/>
            Purpose: <select name="purpose">
                     <option value="Seeker">Seeker</option>
                     <option value="Assignor">Assignor</option>
            </select><br/>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
