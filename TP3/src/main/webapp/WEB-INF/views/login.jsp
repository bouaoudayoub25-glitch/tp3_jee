<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Formulaire</title></head>
<body>
<h1>Login</h1>
<% if (request.getAttribute("err") != null) { %>
    <p style="color:red;">Identifiants incorrects.</p>
<% } %>


<form method="post" action="/TP3/Login">
<input type="text" name="username" placeholder="username" required>
<input type="password" name="password" placeholder="password" required>

<button type="submit">Login</button>
</form>
</body>
</html>