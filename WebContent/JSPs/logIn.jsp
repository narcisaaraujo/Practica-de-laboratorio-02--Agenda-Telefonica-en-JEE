<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<!--===============================================================================================-->
	<link rel="icon" type="image/png"
		href="/PracticaServlets/img/icons/favicon.ico" />
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
										href="/PracticaServlets/css/util.css">
										<link rel="stylesheet" type="text/css"
											href="/PracticaServlets/css/main.css">

											<link rel="stylesheet"
												href="https://www.w3schools.com/w3css/4/w3.css">
												<link rel="stylesheet"
													href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
													<!--===============================================================================================-->
													<title>Inicio de sesion agenda</title>
</head>
<body>
	<header id="header"> <nav class="links" style="--items: 5;">
	<a href="/PracticaServlets/index.html"><li class="w3-xlarge"><i
			class="fa fa-home"></i> Home</li></a> <span class="line"></span> </nav> </header>

	<form action="/PracticaServlets/SesionController" method="get"
		id="registro">
		<div class="limiter">
			<div class="container-login100"
				style="background-image: url('/PracticaServlets/img/fondo.jpg');">
				<div class="wrap-login100 p-t-30 p-b-50">
					<span class="login100-form-title p-b-41"> Inicio de sesion </span>
					<form class="login100-form validate-form p-b-33 p-t-5">

						<div class="wrap-input100 validate-input"
							data-validate="Enter username">
							<input class="input100" type="email" name="correo"
								placeholder="Correo del usuario" required>
						</div>

						<div class="wrap-input100 validate-input"
							data-validate="Enter password">
							<input class="input100" type="password" name="contrasena"
								placeholder="Contrasena" minlength="8" required>
						</div>

						<div class="container-login100-form-btn m-t-32">

							<input class="login100-form-btn" type="submit" value="Iniciar">
								<a class="login100-form-btn" href="registro.jsp">Registrarse</a> <br>
						</div>

					</form>
				</div>
			</div>
		</div>



		<script src="js/main.js"></script>

	</form>

</body>
</html>

