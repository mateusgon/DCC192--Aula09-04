<%@page import="java.util.List"%>
<%@page import="br.ufjf.dcc192.ListaDeTarefas"%>
<%@page import="br.ufjf.dcc192.Tarefa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Tarefas</title>
    </head>
    <body>
        <h1>Lista de Tarefas</h1>
        <table border="1">
            <tbody>
            <%
            for(Tarefa tarefa: (List<Tarefa>)request.getAttribute("tarefas")){
            %>
            <tr>
                <td><%=tarefa.getConcluida()?"Concluída":"A fazer"%></td>
                <td><%=tarefa.getTitulo()%></td>
                <td><%=tarefa.getDescricao()%></td>
            </tr>
            <%
            }
            %>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3"><a href="nova.html">Nova Tarefa</a></td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>
