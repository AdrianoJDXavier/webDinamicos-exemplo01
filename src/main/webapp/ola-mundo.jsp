<%-- 
    Document   : ola-mundo
    Created on : 28/08/2017, 21:34:37
    Author     : alunoces
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%
            Integer count = (Integer) session.getAttribute("count");
            if (count == null) {
                count = 0;
            }
            count++;
            session.setAttribute("count", count);
            %>

            <h1>Voce visitou essa página <%out.println(count);%> vezes</h1>
    </body>
</html>
