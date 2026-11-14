<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<h1>bienvenu <%= request.getAttribute("user")%></h1>
	<a href="${pageContext.request.contextPath}/Logout">LogOut</a>
	<a href="${pageContext.request.contextPath}/Produits">Produit</a>

</body>
</html>