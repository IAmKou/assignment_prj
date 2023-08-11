<%-- 
    Document   : main
    Created on : Aug 7, 2023, 10:52:50 AM
    Author     : ACER
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Job Portal Page</title>
    </head>
    <body>
                Welcome ${account.uid}
         <c:if test="${account.tid eq 2}">
        <a href="createJobLocation.jsp">Create a new job</a>
         </c:if>
        
    </body>
</html>
