<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.error!=null}">
		<div>donnees incorrectes</div>
	</c:if>

	<form method="post" action="produit">
		id:<input name="id"> nom:<input name="nom"> prix: <input
			name="prix" type="number" value="0">
		<button type="submit">envoyer</button>
	</form>
</body>
</html>