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
	<p>le produit:${produit.libelle}${produit.prix}</p>
	<table>
		<c:forEach items="${produits}" var="p">
			<tr>
				<td>${p.libelle}</td>
				<td>${p.prix}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>