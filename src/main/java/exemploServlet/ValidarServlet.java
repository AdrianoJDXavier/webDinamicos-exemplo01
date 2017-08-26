package exemploServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidarServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String password = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidarServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Validar Password</h1>");
            out.println("</body>");
            
        if(password.equals(confirmation) && password.length() >= 8){
            out.println("<p>Password Confirmado!</p>");
            out.println("</html>");
        }else
            out.println("<p>Password Incorreto!</p>");
            out.println("</html>");
        }
    }

}
