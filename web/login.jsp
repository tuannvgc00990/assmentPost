<%-- 
    Document   : login
    Created on : Mar 4, 2018, 7:39:28 PM
    Author     : tuan5
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login!</h1>
        <form action="adminServlet?action=login" method="POST">
            user:<input type="text" name="username"/>
            pass:<input type="password" name="pass"/>
            <input type="submit" value="login"/>
            <span style="color: red;"><c:out value="${param.mgs}"/></span>
        </form>
    </body>
</html>
