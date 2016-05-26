<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="fr">
<head>
<title>Pizzeria</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/feuilleDeStylePizzeria.css">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-9">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nom</th>
							<th>Code</th>
							<th>Prix</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pizza" items="${listePizza}"> 
						<tr>
							<td>${pizza.nom}</td>
							<td>${pizza.code}</td>
							<td>${pizza.prix}</td>
							<td><a href=<c:url value="/pizzas/edit?code=${pizza.code}"></c:url> class="btn btn-success">Modifier</a></td>
							<td><a href="#" class="btn btn-danger">Supprimer</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>

</body>
</html>