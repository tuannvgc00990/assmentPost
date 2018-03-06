<%-- 
    Document   : addpost
    Created on : Mar 5, 2018, 6:02:32 PM
    Author     : tuan5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="adminServlet?action=addpost" method="POST">
            <input type="text" name="title" placeholder="Title"/>
            <input type="text" name="content" placeholder="content"/>
            <input type="text" name="imgpath" placeholder="path"/>
            <select name="selectauthor" id="select">
                <option value="1">Chi minh toi</option>
                <option value="2">Ban be</option>
                <option value="3">Moi nguoi</option>
            </select>
            <input type="submit" value="Nhap"/>
        </form>
    </body>
</html>
