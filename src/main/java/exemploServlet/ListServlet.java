package exemploServlet;

import Classes.Tarefa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {

    private List<Tarefa> tarefas = new ArrayList();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        boolean valor = "ON".equals(request.getParameter("valor"));
        Tarefa tarefa = new Tarefa();
        tarefa.setDescrição(descricao);

        tarefas.add(tarefa);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>To DO Dinâmico</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>To DO Dinâmico</h1>");
            out.println("<h2>Lista de tarefas web dinâmica</h2>");
            out.println("<p>Insira suas tarefas na lista abaixo e controle o que precisa fazer</p>");
            out.println("<ul>");
            out.println("<li>Exemplo de tarefa</li>");
            out.println("<li>Tarefa 3</li>");
            out.println("<li>Outra tarefa</li>");
            for (int i = 0; i < tarefas.size(); i++) {
                if (valor == true) {
                    out.println("<strong><li>" + tarefas.get(i).getDescrição() + "</li></strong>");
                } else {
                    out.println("<li>" + tarefas.get(i).getDescrição() + "</li>");
                }
            }
            out.println("</ul>");
            out.println("<hr>");
            out.println("<form action='list' method='post'>");
            out.println("<input type='text' name='descricao' placeholder='Insira nova tarefa' />");
            out.println("<input type='checkbox' name='valor' value='ON' />");
            out.println("<input type='submit' value='Enviar' />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
