package exemploServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        String text = request.getParameter("text");
        String action = request.getParameter("action");
        if(action != null && text != null){
        switch (action) {
            case "upper":
                text = text.toUpperCase();
                break;
            case "lower":
                text = text.toLowerCase();
                break;
            case "trim":
                text = text.replaceAll(" ", "");
                break;
            case "snake":
                text = text.toLowerCase().replaceAll(" ", "-");
                break;
            default:
        }
        }else
            text = "";

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Texto Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Texto Servlet</h1>");
            out.print("<p>"+text+"</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
