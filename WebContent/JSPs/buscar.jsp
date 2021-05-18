<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png" href="…">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
<link rel="stylesheet" href="/PracticaServlets/css/agenda.css">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/PracticaServlets/css/usuario/util.css">
<link rel="stylesheet" type="text/css"
	href="/PracticaServlets/css/usuario/main.css">

<link rel="stylesheet" type="text/css"
	href="/PracticaServlets/css/usuario/tabla.css">
<link rel="stylesheet" type="text/css"
	href="/PracticaServlets/css/usuario/menu.css">
<script>
	
</script>
<title>Busqueda</title>
</head>
<body>
	<header id="header">
		<nav class="links" style="-items: 4;">
			<a href="/PracticaServlets/index.html">Inicio</a> <span class="line"></span>
			<a href="/PracticaServlets/VisualizacionController">Atras</a> <span class="line"></span>
			<a href="LogoutServlet">Salir</a><span class="line"></span>
		</nav>
	</header>
	<br>
	<br>

	<form action="/PracticaServlets/BuscarUsuario" autocomplete="off">
		<fieldset class="url">
			<input id="url" type="text" name="usuario"
				onkeypress="return numeros(this)" required> <label for="url"><i
				class="fa fa-search" aria-hidden="true"></i> Cedula a buscar</label>
			<div class="after"></div>
		</fieldset>
		<fieldset class="enter">
			<input type="submit" value="Buscar" />
		</fieldset>
		<input id="url2" type="text" name="usuario"> <label for="url2">
		</label>

	</form>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:set var="p1" value="${requestScope['telefonos']}" />

	<table class=container>
		<tr>
			<td>Usuario</td>
			<td>Tipo tlf.</td>
			<td>Numero</td>
			<td>Operadora</td>
			<td>Correo</td>
			<td>Llamar</td>
			<td>Enviar Correo</td>

		</tr>
		<c:forEach items="${telefonos}" var="telefonos">


			<tr>
				<td>${userexistente.nombre}${userexistente.apellido}</td>
				<td>${telefonos.tipo}</td>
				<td>${telefonos.numero}</td>
				<td>${telefonos.operadora}</td>
				<td>${userexistente.correo}</td>
				<td><a href="tel:+593${telefonos.numero}"
					style="width: 100%; height: 100%"> <img src="img/llamar.png"
						text-aling="center" width="40" height="40" />
				</a></td>
				<td><a href="mailto:${userexistente.correo}"
					style="width: 100%; height: 100%"><img src="img/correo.png"
						text-aling="center" width="40" height="40" /></a></td>

			</tr>

		</c:forEach>
	</table>

</body>
</html>