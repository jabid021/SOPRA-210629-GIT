<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
    
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


      <h1>Liste des trajets</h1>
           <input id="btnAddTrajet" type="button" class ="btn btn-success" value="Ajouter">
           <input id="filterTrajet" placeholder="filtre">
           <table class="table table-striped">
             <thead>
               <tr>
                 <th>Id</th>
                 <th>Distance</th>
                 <th>Depart</th>
                 <th>Destination</th>
                 <th>Actions</th>
                 </tr>
             </thead>
             <tbody id="contentTable">
            	 <c:forEach items="${trajets}" var="trajet">
					<tr>
						<td>${trajet.id}</td>
						<td>${trajet.distance}</td>
						<td>${trajet.depart.nom}</td>
						<td>${trajet.destination.nom}</td>
						<td>
                   			<input onclick="updateTrajet(${trajet.id},'${trajet.distance}','${trajet.depart.id}','${trajet.destination.id}')" type="button" class ="btn btn-warning" value="Modifier">
                   			<input onclick="deleteTrajet(${trajet.id})" type="button" class ="btn btn-danger" value="Supprimer">
                		 </td>
					</tr>
				</c:forEach>
     
             </tbody>
           </table>


      <div id="addFormTrajet">
             <h3>Ajouter nouveau trajet</h3>
             <form action="trajets" method="post">
             	<input type="hidden" name="type_form" value="POST">
               <label for="add_distance">Distance :</label> <input required id="add_distance" name="distance" type="text" placeholder="Saisir la distance"><br>
               <label for="add_depart" >Depart :</label>
               <select id="add_depart" name="id_depart">
               	<c:forEach items="${villes}" var="ville">
					<option value="${ville.id}">${ville.id}-${ville.nom}</option>
				</c:forEach>
				</select><br>
               <label for="add_destination">Destination :</label>
               <select id="add_destination" name="id_destination" >
               	<c:forEach items="${villes}" var="ville">
					<option value="${ville.id}">${ville.id}-${ville.nom}</option>
				</c:forEach>
				</select><br>

               <input class ="btn btn-success" type="submit" name="ajouter" value="Ajouter">
             </form>
         </div>

           <div id="updateFormTrajet">
             <h3>Modifier le trajet</h3>
            
			<form action="trajets" method="post">
             	<input type="hidden" id="update_id_trajet" name="id">  
             	<input type="hidden" name="type_form" value="PUT">

               <label for="update_distance">Distance :</label> <input required name="distance" id="update_distance" type="text" placeholder="Saisir le distance"><br>
               <label for="update_depart">Depart :</label>
               <select id="update_depart" name="id_depart">
               	<c:forEach items="${villes}" var="ville">
					<option value="${ville.id}">${ville.id}-${ville.nom}</option>
				</c:forEach>
				</select><br>
               <label for="update_destination">Destination :</label>
               <select id="update_destination" name="id_destination">
               	<c:forEach items="${villes}" var="ville">
					<option value="${ville.id}">${ville.id}-${ville.nom}</option>
				</c:forEach>
				</select><br>
               <input class ="btn btn-warning" type="submit" name="modifier" value="Modifier">
             </form>
           </div>
           <a href="admin.html">Retour</a>
         </div>
    </div>
  </div>


<script>

filterTrajet.onkeyup=filtreAjax;

btnAddTrajet.onclick=function()
{
	updateFormTrajet.style.display="none";
	addFormTrajet.style.display="block";
}

function updateTrajet(id,distance,id_depart,id_destination)
{
	addFormTrajet.style.display="none";
	updateFormTrajet.style.display="block";

	update_id_trajet.value=id;
	update_distance.value=distance;
	update_id_depart.value=id_depart;
	update_id_destination.value=id_destination;
}



function deleteTrajet(idTrajet)
{
	if(confirm("Etes vous sur de vouloir supprimer ce compte ?"))
	{
		$.ajax("trajets", {
			type: "POST",
			data: 
			{
				id : idTrajet,
				type_form:"DELETE"
			},
			success: function (resp) {
				location.href="trajets";
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
			search : filterTrajet.value,
			page:"trajets"
		},
		success: function (resp) {
			contentTable.innerHTML=resp;
		}
	});
}


</script>
</body>
</html>