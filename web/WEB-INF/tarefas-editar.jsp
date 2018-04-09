<%@page import="br.ufjf.dcc192.ListaDeTarefas"%>
<%@page import="br.ufjf.dcc192.Tarefa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar tarefa</title>
    </head>
    <body>
        <% Tarefa t = (Tarefa)request.getAttribute("tarefa"); 
           int codigo = ListaDeTarefas.getInstance().indexOf(t);
        %> 
        <h1> Edição da tarefa </h1>
        <form method="post">
            <label>Titulo: <input value="<%= t.getTitulo() %>" name="titulo"/> </label>
            <label>Descrição: <textarea name="descricao" rows="4"> <%= t.getDescricao() %> </textarea> </label>
            <input type="submit"/>
            <input type="reset"/>
            <input type="hidden" value="<%=codigo%>" name="operacao"/>
        </form>
    </body>
</html>
