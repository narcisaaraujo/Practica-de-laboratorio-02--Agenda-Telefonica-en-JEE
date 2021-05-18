<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
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
										<link rel="stylesheet" type="text/css"
											href="vendor/animate/animate.css">
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

																			
																			<title>Agenda</title>
</head>
<body>
	<header id="header"> <nav class="links" style="--items: 5;">
	<a href="/PracticaServlets/index.html">Home</a> 
		 
		<a href="LogoutServlet">Salir</a>
	<span class="line"></span> </nav>

	<div class="menu">
		<!-- Menu icon -->
		<div class="icon-close">
			<img src="https://imgur.com/download/GcHTJg2">
		</div>
	</header>
	<form action="/PracticaServlets/BuscarUsuario" autocomplete="off">
		<fieldset class="">
			<input id="url" type="text" 
				name="usuario"><label for="url"><i
					class="fa fa-search" aria-hidden="true"></i> Cedula a Buscar</label>
				<div class="after"></div>
		</fieldset>
		<fieldset class="enter">
			<input type="submit" value="Buscar" />
		</fieldset>
		<input id="url2" type="text" name="usuario"> <label for="url2">  </label>
	</form>

	<br><br><br><br><br><br><br><br><br><br>
											<h2>Agenda Telefonica</h2> <c:set var="p1"
												value="${requestScope['usuarios']}" />

											<table class="container">
												<tr>
													<td>Cedula</td>
													<td>Nombre</td>
													<td>Apellido</td>
													<td>Correo</td>
												</tr>
												<c:forEach items="${usuarios}" var="usuario">
													<tr>
														<td>${usuario.cedula}</td>
														<td>${usuario.nombre}</td>
														<td>${usuario.apellido}</td>
														<td>${usuario.correo}</td>
													</tr>


												</c:forEach>
											</table>
</body>
</html>