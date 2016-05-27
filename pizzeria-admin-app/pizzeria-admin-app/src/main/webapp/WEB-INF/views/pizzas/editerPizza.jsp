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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container-fluid ">
		<div class="row content">
			<div class="container-fluid " style="padding:50px">
				<form action="<%=request.getContextPath()%>/pizzas/edit" method="post">
					<fieldset>
						<!-- Form Name -->
						<legend>Editer Pizza</legend>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-2 control-label" for="Id">ID</label>
							<div class="col-md-9">
								<input id="id" name="id" type="text"
									placeholder="Id" class="form-control input-md" value="${pizza.id}" readonly="readonly">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label" for="Code">Code</label>
							<div class="col-md-9">
								<input id="code" name="code" type="text"
									placeholder="Nouveau Code" class="form-control input-md" value="${pizza.code}" required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label" for="prix">Nom</label>
							<div class="col-md-9">
								<input id="nom" name="nom" type="text" placeholder="Nouveau Nom"
									class="form-control input-md" value="${pizza.nom}" required>
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-2 control-label" for="prix">Prix</label>
							<div class="col-md-9">
								<input id="prix" name="prix" type="text"
									placeholder="Nouveau Prix" class="form-control input-md" value="${pizza.prix}" required>

							</div>
						</div>

						

						<!-- Button -->
						<div class="form-group">
							<div class="col-md-2 col-md-offset-9">
								<button type="submit" class="btn btn-success">Envoyer</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>

		<footer class="container-fluid">
			<p>Footer Text</p>
		</footer>
</body>
</html>