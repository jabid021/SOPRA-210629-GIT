<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		bonjour
		<%=request.getAttribute("prenom").toString().toUpperCase()%></h1>
	<p>point ${requestScope.prenom}</p>
	<p>tableau ${requestScope['prenom']}</p>
	<p>${prenom}</p>
</body>
</html>