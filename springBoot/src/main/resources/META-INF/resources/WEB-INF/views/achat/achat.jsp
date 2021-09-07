<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
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
		<h1>achats</h1>
		<c:forEach var="indice" begin="0" end="${produits.totalPages - 1}"
			step="1">
			<c:choose>
				<c:when test="${produits.number == indice }">
					<a href="?page=${indice}" class="btn btn-link btn-lg">${indice}</a>
				</c:when>
				<c:otherwise>
					<a href="?page=${indice}" class="btn btn-link">${indice}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<table clas="table">
			<c:forEach items="${produits.iterator()}" var="p">
				<form action="${ctx}/achat/addPanier" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}"> <input type="hidden" name="id"
						value="${p.id}">
					<tr>
						<td>${p.libelle}</td>
						<td>${p.prix}</td>
						<td><input type="number" id="quantite" name="quantite"
							class="form-control"></td>
						<td><button type="submit" class="btn btn-link">ajouter
								au panier</button></td>
						<td>${panier.get(p)}</td>

					</tr>
				</form>
			</c:forEach>
		</table>
		<a href="${ctx}/achat/recap" class="btn btn-link">recapitulatif</a>
	</div>
</body>
</html>