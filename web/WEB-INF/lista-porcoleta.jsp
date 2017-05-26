<%-- 
    Document   : lista-porcoleta
    Created on : 26/05/2017, 17:17:19
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
        <h1>Lista de Coletas</h1>
        <div style="color: red;">${mensagem}</div>
        <table>
            <thead>
                <tr>
                <th>Id</th>
                <th>Descrição</th>
                <th>Data</th>
                </tr>
            </thead>    
            <tbody>
                <c:forEach var="coleta" items="${coletas}">    
                <tr>
                    <td>${coleta.id}</a></td>
                    <td>${coleta.descricao}</td>
                    <td>${coleta.data}</td>
                </tr>
                </c:forEach>
            </tbody>
    </body>
</html>
