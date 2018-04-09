<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Tarefa</title>
    </head>
    <body>
        <h1>Nova Tarefa</h1>
        <form method="post">
            <label>Titulo: <input name="titulo" /></label>
            <label>Descrição: <textarea name="descricao" rows="4"></textarea></label>
            <input type="submit"/>
            <input type="reset"/>
        </form>
    </body>
</html>
