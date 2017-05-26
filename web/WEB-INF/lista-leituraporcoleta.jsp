<%-- 
    Document   : lista-leituraporcoleta
    Created on : 26/05/2017, 17:17:00
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
        <h1>Lista de Pedidos</h1>
        <div style="color: red;">${mensagem}</div>
        <table>
            <thead>
                <tr>
                <th>Id</th>
                <th>Coleta</th>
                <th>Local</th>
                <th>Leitura</th>
                <th>Unidade</th>
                <th>Atualização</th>
                </tr>
            </thead>    
            <tbody>
                <c:forEach var="leituraColeta" items="${leituracoleta}">    
                <tr>
                    <td>${leituracoleta.id}</td>
                    <td>${leituracoleta.coleta}</td>
                    <td>${leituracoleta.local}</td>
                    <td>${leituracoleta.leitura}</td>
                    <td>${leituracoleta.unidade}</td>
                    <td>${leituracoleta.atualizacao}</td>
                    
                </tr>
                </c:forEach>
            </tbody>
    </body>
</html>
