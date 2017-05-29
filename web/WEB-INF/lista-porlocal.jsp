<%-- 
    Document   : lista-porlocal
    Created on : 26/05/2017, 17:16:39
    Author     : alunoces
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%@include file="JSPF/Menu.jspf" %>
        <h1>Lista por local</h1>
        <div style="color: red;">${mensagem}</div>
        <table>
            <thead>
                <tr>
                <th>Coleta</th>
                <th>Local</th>
                </tr>
            </thead>    
            <tbody>
                <c:forEach var="local" items="${local}">    
                <tr>
                    <td>${local.coleta}</td>
                    <td>${local.local}</td>
                </tr>
                </c:forEach>
            </tbody>
    </body>
</html>
