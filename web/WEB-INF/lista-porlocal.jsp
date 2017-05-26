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
        <h1>Lista de Pedidos</h1>
        <div style="color: red;">${mensagem}</div>
        <table>
            <thead>
                <tr>
                <th>Dono</th>
                <th>Valor Total</th>
                </tr>
            </thead>    
            <tbody>
                <c:forEach var="pedido" items="${pedidos}">    
                <tr>
                    <td>${pedido.dono}</td>
                    <td>${pedido.valor}</td>
                </tr>
                </c:forEach>
            </tbody>
    </body>
</html>
