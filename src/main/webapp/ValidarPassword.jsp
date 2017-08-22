<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar Password</title>
    </head>
    <body>
        <h1>Confirmar Password</h1>
        <form action="/validator" method="POST">
            <label>Senha:</label>
            <input type="password" name="password" value="" />
            <label>Confirmação:</label>
            <input type="password" name="confirmation" value="" />
        </form>
    </body>
</html>
