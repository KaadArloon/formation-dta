<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.dao.pizza.IPizzaDao"%>
<%@page import="fr.pizzeria.dao.pizza.PizzaDaoImpl"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lister pizzas</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Code</th>
					<th>Nom</th>
					<th>Prix</th>
					<th>Image</th>
				</tr>
			</thead>
			<tbody>
				<% 
				List<Pizza> list = (List<Pizza>) request.getAttribute("listpizzas");
				for (Pizza p : list){
				%>
				<tr>
					<td><%= p.getId() %></td>
					<td><%= p.getCode() %></td>
					<td><%= p.getNom() %></td>
					<td><%= p.getPrix() %></td>
					<td><%= p.getUrlImage() %></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</body>
</html>