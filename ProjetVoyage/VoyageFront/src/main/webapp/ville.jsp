<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css">
<meta charset="utf-8">

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>
</head>
<body>


<h1>Liste des villes</h1>
     <input id="btnAddVille" type="button" class ="btn btn-success" value="Ajouter">
     <input id="filterVille" placeholder="filtre">
     <table class="table table-striped">
       <thead>
         <tr>
           <th >Id</th>
           <th>Nom</th>
           <th>Caractère</th>
           <th>Département</th>
           </tr>
       </thead>
        <tbody id="contentTable">
            	 <c:forEach items="${ville}" var="ville">
					<tr>
						<td>${ville.id}</td>
						<td>${ville.nom}</td>
						<td>${ville.carac}</td>
						<td>${ville.departement.nom}</td>
						<td>
                   			<input onclick="updateVilles(${ville.id},'${ville.nom}','${ville.carac}','${ville.departement.nom}')" type="button" class ="btn btn-warning" value="Modifier">
                   			<input onclick="deleteVille(${ville.id})" type="button" class ="btn btn-danger" value="Supprimer">
                		 </td>
					</tr>
				</c:forEach>  
             </tbody>
     </table>



<div id="addFormVille">
       <h3>Ajouter une nouvelle ville </h3>
       <form action="villes" method="post">
         <input hidden id="add_id_ville" name="id_ville" type="text" ><br>
         <input hidden id="add_id_ville" name="type_form" value="POST" ><br>
         <label for="add_nom">Nom ville :</label> <input required id="add_nom" name="nom_ville" type="text" placeholder="Saisir le nom de la ville"><br>
         <label for="add_carac">Caractère :</label> <input required id="add_carac" name="caractere" type="text" placeholder="Saisir le caractère de la ville"><br>
         <select id="add_dept" name="dept">
             <option value="choose" selected="selected">Choisir un département</option>
             <option value="2">Paris</option>
             <option value="1">Ile-et-Vilaine</option>
         </select><br>

         <input class ="btn btn-success" type="submit" name="ajouter" value="Ajouter">
       </form>
   </div>


     <div id="updateFormVille">
     
       <h3>Modifier la ville</h3>
       <form action="villes" method="post">
        <input type="hidden" id="upd_id_ville" name="id_ville">
		<input type="hidden" name="type_form" value="PUT">
         <label for="update_nom">Ville :</label> <input required id="upd_nom" name="nom_ville" type="text" placeholder="Saisir le nom de la ville"><br>
         <label for="update_carac">Caractère :</label> <input required id="upd_carac" name="caractere" type="text" placeholder="Saisir le caractère de la ville"><br>
         <select id="upd_dept" name="dept">
             <option value="2" >Paris</option>
             <option value="1">Ile-et-Vilaine</option>
         </select><br>

         <input class ="btn btn-warning" type="submit" name="modifier" value="Modifier">
       </form>
     </div>
     <a href="admin.html">Retour</a>


<script>

   filterVille.onkeyup=filtreAjax;

btnAddVille.onclick=function()
{
	updateFormVille.style.display="none";
	addFormVille.style.display="block";
}

function updateVilles(id,nom,caractere,departement)
{
	upd_nom.removeAttribute("selected");
	upd_carac.removeAttribute("selected");
	
	addFormVille.style.display="none";
	updateFormVille.style.display="block";

	upd_id_ville.value=id;
	upd_nom.value=nom;
	upd_carac.value=caractere;
	
}




function deleteVille(idVille)
{
	if(confirm("Etes vous sur de vouloir supprimer cette ville ?"))
	{
		$.ajax("villes", {
			type: "POST",
			data: 
			{
				id : idVille,
				type_form:"DELETE"
			},
			success: function (resp) {
				location.href="villes";
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
			search : filterVille.value,
			page:"ville"
		},
		success: function (resp) {
			contentTable.innerHTML=resp;
		}
	});
}


</script>


</body>
</html>