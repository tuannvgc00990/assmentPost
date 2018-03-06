<%-- 
    Document   : index
    Created on : Mar 4, 2018, 8:23:24 PM
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
        <c:set var="tuan" value="${sessionScope.User}" scope="session"/>
        <h1>Well come <c:out value="${tuan.getUsername()}"/></h1>
        <jsp:useBean class="model.postBean" id="bean" scope="session"/>
        <a href="adminServlet?action=addtopost">Add post</a><br/>
        <c:forEach var="p" items="${bean.getAllPostByUser(tuan.getId())}">
            <a href="adminServlet?action=viewpost&id=${p.getIdPost()}"><c:out value="${p.getTitle()}"/></a><br/>
        </c:forEach>


    </body>
</html>
