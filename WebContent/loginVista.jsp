<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=divice-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<title>Login_Registro</title>
	
</head>
<body style="background-image: url('bootstrap/img/fondo.jpg'); background-repeat: no-repeat; background-size: cover;">
	<form action="Login" method="post">
		<div class="container">
			<div class="row">
				
				<div class="col-md-3"></div>
				
				<div class="col-md-6 col-xs-12">
					<div class="jumbotron">
						<h1 class="text-center">Login</h1>
						<br>
						<p class="text-denger">${error}</p>
						<div class="form-group">
							<label class="control-lable" for="usercorreo">Correo</label>			
							<input type="text" name="usercorreo" class="form-control" placeholder="User_correo">
						</div>
						<div class="form-group">
							<label class="control-label" for="password">Contraseña</label>
							<input type="password" name="password" class="form-control" placeholder="contraseña">
						</div>
						<input type="checkbox" name="remember"> Recordame ?
						<br><br>
						<div class="pull-right">
							<button type="submit" name="act" class="btn btn-outline-warning" value="Iniciar Sesion">Iniciar Sesion</button>
							<button type="submit" name="act" class="btn btn-outline-dark" value="Registrarme">Registrarme</button>
						</div>
					</div>
				</div>
				<div class="col-md-3"></div>										
				
			</div>
		</div>
	</form>
	<script type="text/javascript" arc="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" arc="bootstrap/js/jquery.js"></script>
</body>
</html>