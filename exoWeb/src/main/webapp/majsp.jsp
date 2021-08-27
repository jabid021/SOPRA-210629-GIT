<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%-- commentaire jsp --%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ma 1ere JSP</h1>
	<p style="color: <%=request.getParameter("couleur")%>">
		bonjour
		<%=request.getParameter("user")%>
	</p>
	<%
	if (request.getParameter("nom") != null) {
	%>
	<p>le parametre nom est positionné :${param.nom}</p>
	<%
	} else {
	%>
	<p>pas de parametre nom</p>
	<%
	}
	%>
	<%-- commentaire jsp --%>
	<table>
		<%
		//commentaire java
		for (int i = 0; i < 10; i++) {
		%>
		<tr>
			<td>i=</td>
			<td><%=i%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>