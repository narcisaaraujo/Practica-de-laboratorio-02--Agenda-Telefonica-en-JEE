<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=divice-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<title>Registro</title>
	<script>
	  function mostrarContrasena(){
	      var tipo = document.getElementById("password");
	      if(tipo.type == "password"){
	          tipo.type = "text";
	      }else{
	          tipo.type = "password";
	      }
	  }
	</script>
	
</head>
<body style="background-image: url('bootstrap/img/intro.jpg'); background-repeat: no-repeat; background-size: cover;">
	<form action="Registrar" method="post">
		<div class="container">
			<div class="row">
				
				<div class="col-md-3"></div>
				
				<div class="col-md-6 col-xs-12">
					<div class="jumbotron">
						<h1 class="text-center">Proceso de Registro</h1>
						<br>
						<div class="form-group">
							<label class="control-lable" for="cedula">Cedula</label>			
							<input type="text" name="cedula" class="form-control" placeholder="Ingresar Cedula">
						</div>
						<div class="form-group">
							<label class="control-label" for="nombres">Nombres</label>
							<input type="text" name="nombres" class="form-control" placeholder="Ingresar dos nombres">
						</div>
						<div class="form-group">
							<label class="control-label" for="apellidos">Apellidos</label>
							<input type="text" name="apellidos" class="form-control" placeholder="Ingresar dos apellidos">
						</div>
						<div class="form-group">
							<label class="control-label" for="correo">Correo</label>
							<input type="text" name="correo" class="form-control" placeholder="Ingresar correo">
						</div>
						<div class="form-group">
							<label class="control-label" for="password">Password</label>
							<input type="password" id="password" name="password" class="form-control" placeholder="Ingresar contraseña">
						</div>
						<input type="checkbox" name="remember" onclick="mostrarContrasena()"> Ver Contraseña
						<br><br>
						<div class="pull-right">
							<button type="submit" name="act" class="btn btn-outline-warning" value="Registrar">Registrar</button>
							<button type="submit" name="act" class="btn btn-outline-dark" value="Cancelar">Cancelar</button>
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