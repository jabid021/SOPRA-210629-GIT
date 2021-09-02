<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>liste des clients</h1>
		<a href="${ctx}/client/add" class="btn btn-link">ajouter</a>
		<table class="table">
			<tr>
				<th>id:</th>
				<th>civilte</th>
				<th>prenom</th>
				<th>nom</th>
				<th>date de naissance</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${clients}" var="c">
				<tr>
					<td>${c.id}</td>
					<td>${c.civilite }</td>
					<td>${c.prenom }</td>
					<td>${c.nom }</td>
					<td><fmt:parseDate var="date" value="${c.dateNaissance}"
							pattern="yyyy-MM-dd" /> <fmt:formatDate value="${date}"
							pattern="dd/MM/yyyy" /></td>
					<td><a href="${ctx}/client/edit/${c.id}"
						class="btn btn-outline-primary">editer</a></td>
					<td><a href="${ctx}/client/delete/${c.id}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>