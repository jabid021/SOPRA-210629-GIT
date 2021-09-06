<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>edition fournisseur</h1>
		<form:form action="${ctx}/fournisseur/save" method="post"
			modelAttribute="fournisseur">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true" cssClass="form-control"
					placeholder="numero automatique" />
			</div>
			<div class="form-group">
				<form:label path="civilite">civilite</form:label>
				<!-- 				<select id="civilite" name="civilite"> -->
				<%-- 					<c:forEach items="${civilites}" var="civ"> --%>
				<%-- 						<option value="${civ}">${civ.titre}</option> --%>
				<%-- 					</c:forEach> --%>
				<!-- 				</select> -->
				<form:select path="civilite" cssClass="form-control">
					<form:options items="${civilites}" itemLabel="titre" />
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="prenom">prenom:</form:label>
				<form:input path="prenom" cssClass="form-control" required="true" />
				<form:errors path="prenom" element="div"
					cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input path="nom" cssClass="form-control" required="true" />
				<form:errors path="nom" element="div" cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="societe">societe:</form:label>
				<form:input path="societe" cssClass="form-control" required="true" />
				<form:errors path="societe" element="div"
					cssClass="alert alert-danger"></form:errors>
			</div>
			<div>
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="${ctx}/fournisseur" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>