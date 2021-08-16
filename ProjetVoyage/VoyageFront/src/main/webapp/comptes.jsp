<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css">


<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


<div id="content">

  <div class="tab-content" id="pills-tabContent">
    <div class="tab-pane fade show active" id="pills-Dep" role="tabpanel" aria-labelledby="pills-Dep-tab">


      <h1>Liste des comptes</h1>
           <input id="btnAddCompte" type="button" class ="btn btn-success" value="Ajouter">
           <input id="filterCompte" placeholder="filtre">
           <table class="table table-striped">
             <thead>
               <tr>
                 <th>Id</th>
                 <th>Login</th>
                 <th>Password</th>
                 <th>Type Compte</th>
                 <th>Actions</th>
                 </tr>
             </thead>
             <tbody id="contentTable">
            	 <c:forEach items="${comptes}" var="compte">
					<tr>
						<td>${compte.id}</td>
						<td>${compte.login}</td>
						<td>${compte.password}</td>
						<td>${compte['class'].simpleName}</td>
						<td>
                   			<input onclick="updateCompte(${compte.id},'${compte.login}','${compte.password}','${compte['class'].simpleName}')" type="button" class ="btn btn-warning" value="Modifier">
                   			<input onclick="deleteCompte(${compte.id})" type="button" class ="btn btn-danger" value="Supprimer">
                		 </td>
					</tr>
				</c:forEach>
     
             </tbody>
           </table>


      <div id="addFormCompte">
             <h3>Ajouter nouveau compte</h3>
             <form action="compte" method="post">
             	<input type="hidden" name="type_form" value="POST">
               <label for="add_login">Login :</label> <input id="add_login" required name="login" type="text" placeholder="Saisir le login"><br>
               <label for="add_password">Password :</label> <input id="add_password"  required  name="password" type="text" placeholder="Saisir le password"><br>
               <select id="add_compte" name="type_compte">
                   <option>Client</option>
                   <option>Admin</option>
               </select><br>

               <input class ="btn btn-success" type="submit" name="ajouter" value="Ajouter">
             </form>
         </div>

           <div id="updateFormCompte">
             <h3>Modifier le Compte</h3>
            
			<form action="compte" method="post">
             	<input type="hidden" id="update_id_compte" name="id">  
             	<input type="hidden" name="type_form" value="PUT">

               <label for="update_login">Login :</label> <input required name="login" id="update_login" type="text" placeholder="Saisir le login"><br>
               <label for="update_password">Password :</label> <input required name="password" id="update_password"  type="text" placeholder="Saisir le password"><br>
               <select id="update_typeCompte" name="type_compte">
                 <option id="upd_client">Client</option>
                 <option id="upd_admin">Admin</option>
               </select><br>
               <input class ="btn btn-warning" type="submit" name="modifier" value="Modifier">
             </form>
           </div>
           <a href="admin.html">Retour</a>
         </div>
    </div>
  </div>


<script>

filterCompte.onkeyup=filtreAjax;

btnAddCompte.onclick=function()
{
	updateFormCompte.style.display="none";
	addFormCompte.style.display="block";
}

function updateCompte(id,login,password,compte)
{
	upd_client.removeAttribute("selected");
	upd_admin.removeAttribute("selected");
	
	addFormCompte.style.display="none";
	updateFormCompte.style.display="block";

	update_login.value=login;
	update_password.value=password;
	update_id_compte.value=id;
	if(compte=="Client")
	{
		upd_client.setAttribute("selected","");
	}
	else if(compte=="Admin")
	{
		upd_admin.setAttribute("selected","");
	}
	
}



function deleteCompte(idCompte)
{
	if(confirm("Etes vous sur de vouloir supprimer ce compte ?"))
	{
		$.ajax("compte", {
			type: "POST",
			data: 
			{
				id : idCompte,
				type_form:"DELETE"
			},
			success: function (resp) {
				location.href="compte";
			}
		});
	}	
}


function filtreAjax()
{
	$.ajax("filter", {
		type: "POST",
		data: 
		{
			search : filterCompte.value,
			page:"compte"
		},
		success: function (resp) {
			contentTable.innerHTML=resp;
		}
	});
}


</script>
</body>
</html>