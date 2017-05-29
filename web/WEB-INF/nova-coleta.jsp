<%-- 
    Document   : planejamento
    Created on : 21/05/2017, 23:31:33
    Author     : Bruna Alves
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planejamento</title>
    </head>
    <body>
        <h1>Fase de planejamento - Coleta</h1>
         <div style="color: red;">${mensagem}</div>
        <form action="NovaColeta.html" method="post">
            <div><label> Descrição: <input type="text" name="descricao" placeholder="Digite a descricao" /></label></div>
            <div><label> Data: <input type="text" name="data"/></label></div>
            <div><label> Hora: <input type="text" name="hora"/></label></div>
            <div><input type="submit" /></div>   
        </form>
    </body>
</html>
