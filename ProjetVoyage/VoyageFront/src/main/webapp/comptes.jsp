<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table border>
<tr><th>login</th></tr>
<c:forEach items="${comptes}" var="compte">
	<tr>
		<td>${compte.login}</td>
	</tr>
</c:forEach>

</table>
</body>
</html>