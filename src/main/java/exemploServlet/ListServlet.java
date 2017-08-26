package exemploServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        boolean valor = "on".equals(request.getParameter("valor"));
        Tarefa tarefa = new Tarefa();
        ArrayList<Tarefa> tarefas = new ArrayList();
        tarefas.add("Exemplo de tarefa");
        tarefas.setDescrição("Tarefa 3");
        tarefas.setDescrição("Outra tarefa");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>To DO Dinâmico</title>");
            out.println("<style>");
            out.println("p ,li, h2, h1 {");
            out.println("font-family: cursive;");
            out.println("font-style: oblique;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>To DO Dinâmico</h1>");
            out.println("<h2>Lista de tarefas web dinâmica</h2>");
            out.println("<p>Insira suas tarefas na lista abaixo e controle o que precisa fazer</p>");
            out.println("<ul>");
            out.println("<li>");
            out.println("</li>");
            out.println(tarefas.getDescrição());
            out.println("</ul>");
            out.println("<hr>");
            out.println("<form>");
            out.println("<input type='text' name='descricao' placeholder='Insira nova tarefa' />");
            out.println("<input type='checkbox' name='valor' value='ON' />");
            out.println("<input type='submit' name='enviar' value='Enviar' />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
