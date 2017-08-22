package exemploServlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImprimeRequestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Imprime Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Imprime Request</h1>");
            out.println("<p>Método: " + request.getMethod() + "</p>");
            out.println("<p>Recurso: " + request.getRequestURI() + "</p>");
            out.println("<p>URL completa: " + request.getRequestURL() + "</p>");
            out.println("<p>Parametros de busca: " + request.getQueryString() + "</p>");
            out.println("<p>Cabeçalhos:</p>");
            Enumeration<String> cabecalhos = request.getHeaderNames();
            out.println("     <ul>");
            while (cabecalhos.hasMoreElements()) {
                String cabecalho = cabecalhos.nextElement();
                String valor = request.getHeader(cabecalho);
                out.println("     <li>" + cabecalho + ": " + valor + "</li>");
            }
            out.println("     </ul>");

            out.println("     <p>Corpo:</p>");

            BufferedReader reader = request.getReader();
                String linha;
                while ((linha = reader.readLine()) != null) {
                    out.println(linha + "<br/>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}
