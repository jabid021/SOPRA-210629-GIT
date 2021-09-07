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
		<c:set var="total" value="0" />
		<table class="table">
			<c:forEach items="${panier}" var="element">
				<tr>
					<td>${element.key.libelle}</td>
					<td>${element.key.prix}</td>
					<td>${element.value}</td>
					<td>${element.key.prix * element.value}</td>
				</tr>
				<c:set var="total"
					value="${total + element.key.prix * element.value }"></c:set>
			</c:forEach>
		</table>
		<div>total du panier:${total}</div>
		<form action="${ctx}/achat/valid" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}"> <select name="idClient">
				<c:forEach items="${clients}" var="client">
					<option value="${client.id}">${client.id}${client.prenom}
						${client.nom}</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-primary">valider</button>
		</form>
	</div>
</body>
</html>