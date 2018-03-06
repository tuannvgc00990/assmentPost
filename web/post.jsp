<%-- 
    Document   : post
    Created on : Mar 6, 2018, 11:28:06 AM
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
        <h1>Aloha</h1>
        <c:set scope="session" value="${sessionScope.detail}" var="dt"/>        
        <c:out value="${dt.getTitle()}"/><br/>
        <c:out value="${dt.getContent()}"/><br/>
        <c:out value="${dt.getDatePost()}"/><br/>
        <c:out value="${dt.getImgPath()}"/><br/>
        <form action="adminServvlet?action=comment" method="POST">
            <input type="text" placeholder="comment"/><input type="submit" value="comment"/>
        </form>
            
    </body>
</html>
