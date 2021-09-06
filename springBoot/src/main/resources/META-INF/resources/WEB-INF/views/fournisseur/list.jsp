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
		<h1>liste des fournisseurs</h1>
		<a href="${ctx}/fournisseur/add" class="btn btn-link">ajouter</a>
		<table class="table">
			<tr>
				<th>id:</th>
				<th>civilte</th>
				<th>prenom</th>
				<th>nom</th>
				<th>societe</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${fournisseurs}" var="f">
				<tr>
					<td>${f.id}</td>
					<td>${f.civilite }</td>
					<td>${f.prenom }</td>
					<td>${f.nom }</td>
					<td>${f.societe }</td>
					<td><a href="${ctx}/fournisseur/edit/${f.id}"
						class="btn btn-outline-primary">editer</a></td>
					<td><a href="${ctx}/fournisseur/delete/${f.id}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>