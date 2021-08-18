<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<meta charset="utf-8">
<style>
#errorConnect {
	color: red;
	display: none;
}

#content {
	margin: 75px;
}

body {
	background: #F4EFE7;
}

#container {
	width: 400px;
	margin: 0 auto;
	margin-top: 10%;
}
/* Bordered form */
form {
	width: 100%;
	padding: 30px;
	border: 1px solid #f1f1f1;
	background: #fff;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

#container h1 {
	text-align: center;
}

/* Full-width inputs */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
input[type=submit] {
	background-color: #53af57;
	color: white;
	padding: 14px 20px;
	margin: 8px;
	border: none;
	cursor: pointer;
	width: 100%;
}

input[type=submit]:hover {
	background-color: white;
	color: #53af57;
	border: 1px solid #53af57;
}
</style>

<div id="content" class="container">
	<!--<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" id="pills-emp-tab" data-toggle="pill" href="#pills-emp" role="tab" aria-controls="pills-emp" aria-selected="true">Gestion employés</a>
    </li>
    <li class="nav-item">
      <a class="nav-link " id="pills-ordi-tab" data-toggle="pill" href="#pills-ordi" role="tab" aria-controls="pills-ordi" aria-selected="false">Gestion ordinateurs</a>
    </li>
  </ul>-->
	<div class="tab-content" id="pills-tabContent">
		<div class="tab-pane fade show active" id="pills-emp" role="tabpanel"
			aria-labelledby="pills-emp-tab">

			<h1>Liste des Voyages</h1>
			<input id="btnAddVoy" type="button" class="btn btn-success"
				value="Ajouter"> <input id="filterVoyage">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Durée</th>
						<th>Départ-Arrivée</th>
						<th>Transport</th>
						<th class="d-flex justify-content-around">Actions</th>
					</tr>
				</thead>

				<tbody id="contentTable">

					<c:forEach items="${voyages}" var="voyage">
						<tr>
							<td>${voyage.id}</td>
							<td>${voyage.duree}</td>
							<td>${voyage.trajet.depart.nom}-${voyage.trajet.destination.nom}</td>
							<td>${voyage.transport}</td>
							<td class="d-flex justify-content-around" >
								<input onclick="updateVoy('${voyage.id}','${voyage.duree}','${voyage.trajet.depart.nom}-${voyage.trajet.destination.nom}','${voyage.transport}')" type="button" class="btn btn-warning" value="Modifier" >
								<input onclick="deleteVoy(${voyage.id})" type="button" class="btn btn-danger" value="Supprimer">
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>



			<div id="addFormVoyage" style="display: none">
				<h3>Ajouter nouveau Voyage</h3>
				<form action="voyage" method="post">
					<input type="hidden" name="type_form" value="POST"> <label
						for="add_duree">Duree :</label> <input required id="add_duree"
						name="duree" type="text" placeholder="Saisir la durée du séjour">
					<br> <select id="add_trajet" name="id_trajet">
						<c:forEach items="${trajets}" var="trajet">
							<option value=${trajet.id}>${trajet.depart.nom}-${trajet.destination.nom}</option>
						</c:forEach>
					</select> <br> <select id="newtransport" name="id_transport">
						<c:forEach items="${transports}" var="transport">
							<option value="${transport.nom}">${transport}</option>
						</c:forEach>
					</select><br> <input class="btn btn-success" type="submit"
						name="ajouter" value="Ajouter">
				</form>
			</div>

			<div id="updateFormVoy" style="display: none">
				<h3>Modifier le Voyage</h3>
				<form action="voyage" method="post">
					<input type="hidden" name="type_form" value="PUT"> <input
						type="hidden" id="update_id_voy" name="id_voy"> <label
						for="update_duree">Durée :</label> <input required
						id="update_duree" name="Durée" type="text"
						placeholder="Saisir votre durée"><br> <label
						for="update_depart">Départ-Arrivée :</label> <select
						id="update_trajet" name="id_trajet">
						<c:forEach items="${trajets}" var="trajet">
							<option value="${trajet.id}">${trajet.depart.nom}-${trajet.destination.nom}</option>
						</c:forEach>
					</select> <br> <label for="update_transport">Transport : </label> <select
						id="update_transport" name="id_transport">
						<c:forEach items="${transports}" var="transport">
							<option value="${transport.nom}">${transport}</option>
						</c:forEach>
					</select><br> <input class="btn btn-warning" type="submit"
						name="modifier" value="Modifier">
				</form>
			</div>

	<a href="admin.html">Retour</a>
		</div>
	</div>
</div>



<script>


$(document).ready(function()
{

const btnAddVoy = document.getElementById("btnAddVoy"),
addFormVoyage = document.getElementById("addFormVoyage");

btnAddVoy.addEventListener("click", displayAddForm);


filterVoyage.onkeyup=filtreAjax;

function displayAddForm()
{
  updateFormVoy.style.display="none";
  $("#addFormVoyage").fadeIn("slow");
}
});

function updateVoy(ID,Duree,Depart,Transport)
{
    addFormVoyage.style.display="none";
    
  $("#updateFormVoy").fadeIn("slow");
  
  $("#update_id_voy").value=ID;
  $("#update_duree").value=Duree;
  $("#update_depart").value=Depart;
  $("#update_transport").value=Transport;

}



function deleteVoy(idVoyage)
{
    if(confirm("Etes vous sur de vouloir supprimer ce voyage ?"))
    {
        $.ajax("voyage", {
            type: "POST",
            data: 
            {
                id : idVoyage,
                type_form:"DELETE"
            },
            success: function (resp) {
                location.href="voyage";
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
            search : filterVoyage.value,
            page:"voyage"
        },
        success: function (resp) {
            contentTable.innerHTML=resp;
        }
    });
}


</script>
