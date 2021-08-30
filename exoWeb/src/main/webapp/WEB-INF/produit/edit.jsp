<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<c:if test="${donneeIncorrectes!=null}">
			<div class="alert alert-danger">donnees incorrectes</div>
		</c:if>

		<form method="post" action="crudproduit">
			<input type="hidden" name="q" value="save">
			<div class="form-group">
				<label for="id">id:</label> <input id="id" name="id"
					readonly="readonly" placeholder="generation automatique de l'id"
					class="form-control" value="${produit.id}">
			</div>
			<div class="form-group">
				<label for="nom">nom:</label> <input id="nom" name="nom"
					class="form-control" value="${produit.libelle}">
			</div>
			<div class="form-group">
				<label for="prix">prix:</label> <input type="number" id="prix"
					name="prix" class="form-control" value="${produit.prix}">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">envoyer</button>
			</div>
		</form>
	</div>

</body>
</html>