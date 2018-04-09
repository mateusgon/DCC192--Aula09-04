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
@WebServlet(name = "TarefasServlet", urlPatterns = {"/listar.html", "/nova.html", "/atualizar.html", "/editar.html", "/excluir.html"})
public class TarefasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/listar.html".equals(request.getServletPath())) {
            listarTarefas(request, response);
        } else if ("/nova.html".equals(request.getServletPath())) {
            criarTarefaForm(request, response);
        }
        else if ("/editar.html".equals(request.getServletPath()))
        {
            editarTarefaForma(request, response);
            return;
        }
        else if ("/atualizar.html".equals(request.getServletPath()))
        {
            atualizarTarefaForm(request, response);
            return;
        }
        else if ("/excluir.html".equals(request.getServletPath()))
        {
            excluirTarefa(request, response);
            return;
        }
        response.sendError(404);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("operacao") == null)
        {
            response.setContentType("text/html;charset=UTF-8");
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");
            Tarefa novaTarefa = new Tarefa(titulo, descricao);
            ListaDeTarefas.getInstance().add(novaTarefa);
            response.sendRedirect("listar.html");
        }
        else
        {
            response.setContentType("text/html;charset=UTF-8");
            int obj = Integer.parseInt(request.getParameter("codigo"));
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");
            ListaDeTarefas.getInstance().get(obj).setTitulo(titulo);
            ListaDeTarefas.getInstance().get(obj).setDescricao(descricao);
            response.sendRedirect("listar.html");
        }
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

    private void atualizarTarefaForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        List<Tarefa> tarefas = ListaDeTarefas.getInstance();
        tarefas.get(codigo).setConcluida(true);
        response.sendRedirect("listar.html");
    }
    
    private void editarTarefaForma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        List<Tarefa> tarefas = ListaDeTarefas.getInstance();
        Tarefa tarefa = tarefas.get(codigo);
        request.setAttribute("tarefa", tarefa);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/tarefas-editar.jsp");
        despachante.forward(request, response);
    }

    private void excluirTarefa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        List<Tarefa> tarefas = ListaDeTarefas.getInstance();
        tarefas.remove(codigo);
        response.sendRedirect("listar.html");
  
    }

    
}
