<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
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

		<%-- 		<form method="post" action="${ctx}/produit/save"> --%>
		<!-- 			<div class="form-group"> -->
		<!-- 				<label for="id">id:</label> <input id="id" name="id" -->
		<!-- 					readonly="readonly" placeholder="generation automatique de l'id" -->
		<%-- 					class="form-control" value="${produit.id}"> --%>
		<!-- 			</div> -->
		<!-- 			<div class="form-group"> -->
		<!-- 				<label for="libelle">nom:</label> <input id="libelle" name="libelle" -->
		<%-- 					class="form-control" value="${produit.libelle}"> --%>
		<!-- 			</div> -->
		<!-- 			<div class="form-group"> -->
		<!-- 				<label for="prix">prix:</label> <input type="number" id="prix" -->
		<%-- 					name="prix" class="form-control" value="${produit.prix}"> --%>
		<!-- 			</div> -->
		<!-- 			<div class="form-group"> -->
		<!-- 				<button type="submit" class="btn btn-outline-primary">envoyer</button> -->
		<!-- 			</div> -->
		<!-- 		</form> -->
		${produit}
		<form:form action="${ctx}/produit/save" method="post"
			modelAttribute="produit">
			<div class="form-group">
				<label for="id">id:</label>
				<form:input path="id" readonly="true" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="libelle">libelle:</label>
				<form:input path="libelle" cssClass="form-control" />
				<form:errors path="libelle" element="div"
					cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<label for="prix">prix:</label>
				<form:input type="number" path="prix" cssClass="form-control" />
				<form:errors path="prix" element="div" cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group"> 
				<form:label path="fournisseur">fournisseur:</form:label>
				<form:select path="fournisseur.id" cssClass="form-control">
					<form:option value="">pas de fournisseur</form:option>
					<form:options items="${fournisseurs}" itemLabel="infos" itemValue="id" />
				</form:select>
				<form:errors path="fournisseur"></form:errors>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">envoyer</button>
				<a href="${ctx}/produit" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>

</body>
</html>