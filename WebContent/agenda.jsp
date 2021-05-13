<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenido: ${param.usercorreo}</h1>
	<form action="CerrarSesion" method="post">
		<div class="pull-right">
			<button type="submit" class="btn btn-outline-warning">Cerrar Sesion</button>
		</div>
	</form>
</body>
</html>