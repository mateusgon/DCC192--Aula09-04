package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ice
 */
@WebServlet(name = "TarefasServlet", urlPatterns = {"/listar.html", "/nova.html"})
public class TarefasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/listar.html".equals(request.getServletPath())) {
            listarTarefas(request, response);
        } else if ("/nova.html".equals(request.getServletPath())) {
            criarTarefaForm(request, response);
        }
        response.sendError(404);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        Tarefa novaTarefa = new Tarefa(titulo, descricao);
        ListaDeTarefas.getInstance().add(novaTarefa);
        
        response.sendRedirect("listar.html");
    }
    
    

    private void listarTarefas(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Tarefa> tarefas = ListaDeTarefas.getInstance();
        request.setAttribute("tarefas", tarefas);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/tarefas-listar.jsp");
        despachante.forward(request, response);
    }

    private void criarTarefaForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/tarefas-novo.jsp");
        despachante.forward(request, response);
    }

}
