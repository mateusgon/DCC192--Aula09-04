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
                List<Tarefa> tarefas = (List<Tarefa>)request.getAttribute("tarefas"); 
            for(int i = 0; i < tarefas.size(); i++){
            %>
            <tr>
                <td colspan="3"> <a href="atualizar.html?codigo=<%=i%>"> <%=tarefas.get(i).getConcluida()?"Concluída":"A fazer"%> </a> </td>
                <td><%=tarefas.get(i).getTitulo()%></td>
                <td><%=tarefas.get(i).getDescricao()%></td>
                <td colspan="3"> <a href="editar.html?codigo=<%=i%>"> Editar </a> </td>
                <td colspan="3"> <a href="excluir.html?codigo=<%=i%>"> Excluir </a> </td>
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
