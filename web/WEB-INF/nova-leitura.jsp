<%-- 
    Document   : nova-leitura
    Created on : 22/05/2017, 20:51:48
    Author     : alunoces
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Fase de planejamento - Leitura</h1>
         <div style="color: red;">${mensagem}</div>
        <form method="post">
            <div><label> Unidade: <input type="text" name="descricao" placeholder="Digite a unidade" /></label></div>
            <div><label> Local: <input type="text" name="data" placeholder="Digite o local" /></label></div>
            <div><input type="submit" /></div>   
        </form>
    </body>
</html>
