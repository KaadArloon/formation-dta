<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Editer Pizza</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="text_id">Id</label>
				<div class="col-md-4">
					<input id="text_id" name="text_id" type="text" placeholder=""
						class="form-control input-md">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="code_text">Code</label>
				<div class="col-md-4">
					<input id="code_text" name="code_text" type="text" placeholder=""
						class="form-control input-md">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="text_nom">nom</label>
				<div class="col-md-4">
					<input id="text_nom" name="text_nom" type="text"
						placeholder="nom pizza" class="form-control input-md" required="">
				</div>
			</div>

			<!-- Button Drop Down -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="buttondropdown_categorie">Catégorie</label>
				<div class="col-md-4">
					<div class="input-group">
						<input id="buttondropdown_categorie"
							name="buttondropdown_categorie" class="form-control"
							placeholder="catégorie de la pizza" type="text" required="">
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								Choisir <span class="caret"></span>
							</button>
							<ul class="dropdown-menu pull-right">
								<li><a href="#">POISSON</a></li>
								<li><a href="#">SANS_VIANDE</a></li>
								<li><a href="#">VIANDE</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="button_valider"></label>
				<div class="col-md-8">
					<button id="button_valider" name="button_valider"
						class="btn btn-success">Valider</button>
					<button id="button_annuler" name="button_annuler"
						class="btn btn-danger">Annuler</button>
				</div>
			</div>
		</fieldset>
	</form>
</body>
</html>