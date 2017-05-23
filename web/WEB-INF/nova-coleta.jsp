<%-- 
    Document   : planejamento
    Created on : 21/05/2017, 23:31:33
    Author     : Bruna Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planejamento</title>
    </head>
    <body>
        <h1>Fase de planejamento - Coleta</h1>
         <div style="color: red;">${mensagem}</div>
        <form method="post">
            <div><label> Descrição: <input type="text" name="descricao" placeholder="Digite a descricao" /></label></div>
            <div><label> Data: <input type="text" name="data" placeholder="Digite a data" /></label></div>
            <div><input type="submit" /></div>   
        </form>
    </body>
</html>
