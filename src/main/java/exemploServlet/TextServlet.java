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
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Texto Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Texto Servlet</h1>");
            
            String text = request.getParameter("text");
            String action = request.getParameter("action");
            
            switch(action){
                case "upper":
                    text = text.toUpperCase();
                    break;
                case "lower":
                    text = text.toLowerCase();
                    break;
                case "trim":
                    text = text.trim().replaceAll(" ", "");
                    break;
                case "snake":
                    text = text.toLowerCase().replaceAll(" ", "-");
                    break;
            }
            out.print(text);
            out.println("</body>");
            out.println("</html>");
        }
    }

}
