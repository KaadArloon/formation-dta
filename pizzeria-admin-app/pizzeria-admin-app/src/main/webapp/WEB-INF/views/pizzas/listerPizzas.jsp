<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.dao.pizza.IPizzaDao"%>
<%@page import="fr.pizzeria.dao.pizza.PizzaDaoImpl"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lister pizzas</title>

<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="header.jsp"%>
	<table
		class="col-md-12 table-bordered table-striped table-condensed cf">
		<thead>
			<tr>
				<th>ID</th>
				<th>Code</th>
				<th>Nom</th>
				<th>Prix</th>
				<th>Modifier</th>
				<th>Supprimer</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="list" value="${listpizzas}" />
			<c:forEach var="p" items="${ list }">
			<tr>
				<td>${p.id}</td>
				<td>${p.code}</td>
				<td>${p.nom}</td>
				<td>${p.categorie}</td>
				<td><a
					href="http://localhost:9500/pizzeria-admin-app/pizzas/edit?code=${p.code}"
					class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span></a></td>
				<td><a href="#" class="btn btn-danger"><span
						class="glyphicon glyphicon-remove"></span></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>