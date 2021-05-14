<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ec.edu.ups.modelo.Telefono, java.util.*,ec.edu.ups.DAO.TelefonoDao,ec.edu.ups.DAO.DAOFactory" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=divice-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<title>Insert title here</title>
</head>
<body style="background-image: url('bootstrap/img/fondo-inicio.jpg');background-repeat: no-repeat; background-size: cover;">
	<h1 align="center">Agenda de Contactos ${param.usercorreo}</h1>
	<form action="CerrarSesion" method="post">
		<div class="pull-right">
			<button type="submit" class="btn btn-outline-warning">Cerrar Sesion</button>
		</div>
	</form>
	
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">+ Agregar Telefono</button>
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title" id="exampleModalLabel">Nuevo Telefono</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body" >
	      		<form action="controladorAgenda" method="post" >
	        		<div class="form-group" >
						<label class="control-lable" for="numero" >Numero</label>			
						<input type="text" name="numero" class="form-control" placeholder="Ingresar Nª Celular/telefono ">
					</div>	
					<div class="form-group">
						<label class="control-label" for="tipo">Tipo</label>
						<input type="text" name="tipo" class="form-control" placeholder="Convencional/Celular">
					</div>
					<div class="form-group">
						<label class="control-label" for="operadora">Operadora</label>
						<input type="text" name="operadora" class="form-control" placeholder="Movistar/Claro etc....">
					</div>	
					<div class="pull-right">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	       				<button type="submit" class="btn btn-primary" name="act" value="guardar">Guardar</button>
					</div>
				</form>	
	      </div>
	    </div>
	  </div>
	</div>
	
	<h1 align="center">Contactos</h1>
	<%
		TelefonoDao telefonoDao=DAOFactory.getFactory().getTelefonoDao();
		List<Telefono> list=telefonoDao.find();
		request.setAttribute("listar", list);
	%>  
	<br>
	<br>
	<table class="table table-striped table-bordered dt-responsive table-hover table-condensed">
	  	<tr>
		    <th class="bg-primary">Numero</th>
		    <th class="bg-primary">Tipo</th>
		    <th class="bg-primary">Operadora</th>
		    <th class="bg-primary">Opciones</th>
	  	</tr>
	  	<c:forEach items="${listar}" var="t">
		    <tr>
		        <td >${t.numero}</td>
		        <td>${t.tipo}</td>
		        <td>${t.operadora}</td>
	        	<td class="text-center"><button class="btn btn-primary btn-sm btnedit" data-id="<?=$contacto['id']?>">Editar</button> <button class="btn btn-danger btn-sm btnEliminar" data-id="<?=$contacto['id']?>">Eliminar</button></td>
	      		</tr>
	     </c:forEach>
	     
	      	
	</table>
	
	
</body>
</html>