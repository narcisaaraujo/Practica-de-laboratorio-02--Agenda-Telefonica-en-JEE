<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

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
										<link rel="stylesheet" type="text/css"
											href="/PracticaServlets/css/usuario/menu.css">
											<script>
												function numeros() {

													var z = document
															.getElementById("cedula").value;
													if (!/^[0-9]+$/.test(z)) {
														alert("Error solo debe ingresar numeros (Permitidos: 0-9)");
														document
																.getElementById("cedula").value = "";
													}
												}
												function soloLetras(e) {
													key = e.keyCode || e.which;
													tecla = String
															.fromCharCode(key)
															.toLowerCase();
													letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
													especiales = [ 8, 37, 39,
															46 ];

													tecla_especial = false
													for ( var i in especiales) {
														if (key == especiales[i]) {
															tecla_especial = true;
															break;
														}
													}

													if (letras.indexOf(tecla) == -1
															&& !tecla_especial)
														return false;
												}
											</script>
											<title>Actualizar telefono</title>
</head>
<body>

	<c:set var="p1" value="${requestScope['usuario']}" />
	<c:set var="p2" scope="request" value="${telefono}" />

	<header id="header"> <nav class="links" style="--items: 5;">
	<a href="#">Home</a> <a
		href="/PracticaServlets/SesionController?correo=${usuario.correo}&contrasena=${usuario.contrasena}">Atras</a>
	<a href="LogoutServlet">Salir</a> <span class="line"></span> </nav> </header>
	<br><br>

			<form action="/PracticaServlets/ActTelefono" method="get"
				id="telefono">
				<div class="limiter">
					<div class="container-login100"
						style="background-image: url('/PracticaServlets/img/fondo2.jpg');">
						<div class="wrap-login100 p-t-30 p-b-50">
							<span class="login100-form-title p-b-41"> Actualizar
								Telefono </span>
							<form class="login100-form validate-form p-b-33 p-t-5">
								<div class="wrap-input100 validate-input" data-validate="Numero">
									<input class="input100" type="text" id="numero" minlength="9"
										maxlength="10" onkeyup="return numeros(this)"
										name="tel_numero" value="${telefono.numero}" required>
										<span class="focus-input100" data-placeholder="&#xe82a;"></span>
								</div>

								<br />

								<div class="wrap-input100 validate-input" data-validate="Tipo"
									style="text-align: center;">

									<select name="comboT" id="comboT" class="campo-select">
										<option value="Fijo">Fijo</option>
										<option value="Celular">Celular</option>
									</select>
								</div>

								<br />

								<div class="wrap-input100 validate-input"
									data-validate="Operadora" style="text-align: center;">

									<select name="comboO" id="comboO" class="campo-select">
										<option value="Claro">Claro</option>
										<option value="Movistar">Movistar</option>
										<option value="Tuenti">Tuenti</option>
										<option value="CNT">CNT</option>
										<option value="Etapa">Etapa</option>
									</select>
								</div>
								<p>
									<input type="hidden" value="${telefono.codigo}"
										name="tel_codigo" />
								</p>
								<p>
									<input type="hidden" value="${usuario.correo}"
										name="usu_correo" />
								</p>
								<p>
									<input type="hidden" value="${usuario.contrasena}"
										name="usu_contrasena" />
								</p>

								<div class="container-login100-form-btn m-t-32">

									<input class="login100-form-btn" type="submit"
										value="Actualizar"> <input class="login100-form-btn"
										type="reset" value="Limpiar">
								</div>

							</form>
						</div>
					</div>
				</div>


				<div id="dropDownSelect1"></div>

				<!--===============================================================================================-->
				<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
				<!--===============================================================================================-->
				<script src="vendor/animsition/js/animsition.min.js"></script>
				<!--===============================================================================================-->
				<script src="vendor/bootstrap/js/popper.js"></script>
				<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
				<!--===============================================================================================-->
				<script src="vendor/select2/select2.min.js"></script>
				<!--===============================================================================================-->
				<script src="vendor/daterangepicker/moment.min.js"></script>
				<script src="vendor/daterangepicker/daterangepicker.js"></script>
				<!--===============================================================================================-->
				<script src="vendor/countdowntime/countdowntime.js"></script>
				<!--===============================================================================================-->
				<script src="js/main.js"></script>


			</form>
</body>
</html>