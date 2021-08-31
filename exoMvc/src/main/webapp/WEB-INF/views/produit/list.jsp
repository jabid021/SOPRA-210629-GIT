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
		<h1>liste des produits</h1>
		<c:if test="${delete!=null}">
			<div class="alert alert-primary">produit ${delete} supprimé</div>
		</c:if>
		<table class="table">
			<c:forEach items="${produits}" var="produit">
				<tr>
					<td>${produit.id}</td>
					<td>${produit.libelle}</td>
					<td>${produit.prix}</td>
					<td><a href="edit?id=${produit.id}">editer</a></td>
					<td><a href="delete?id=${produit.id}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-link" href="add">nouveau produit</a>
	</div>
</body>
</html>