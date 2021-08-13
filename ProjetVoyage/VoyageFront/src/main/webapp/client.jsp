<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="metier.Ville" %>
     <%@ page import="dao.DAOVille" %>
     <%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table border>

<tr>
	<th>Id</th>
	<th>Ville</th>
</tr>

<%


DAOVille daoV = new DAOVille();
List<Ville> villes = daoV.findAll();

for(Ville v :villes)
{
	out.println("<tr><td>"+v.getId()+"</td><td>"+v.getNom()+"</td></tr>");
}

%>
</table>
</body>
</html>