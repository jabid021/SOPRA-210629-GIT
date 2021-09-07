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
		<h1>identification</h1>
		<c:if test="${param.error != null }">
			<div class="alert alert-danger">informations incorrectes</div>
		</c:if>
		<form action="" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
			<div class="form-group">
				<label for="username">login:</label> <input id="username"
					class="form-control" name="username" required="required"
					placeholder="saisir votre login">
			</div>
			<div class="form-group">
				<label for="password">mot de passe:</label> <input type="password"
					class="form-control" id="password" name="password"
					required="required" placeholder="sasir votre mot de passe">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">envoyer</button>
				<a href="${ctx}" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>