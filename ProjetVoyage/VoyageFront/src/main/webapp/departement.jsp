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
<title>Departements</title>
</head>
<body>


<div id="content">

  <div class="tab-content" id="pills-tabContent">
    <div class="tab-pane fade show active" id="pills-Dep" role="tabpanel" aria-labelledby="pills-Dep-tab">


      <h1>Liste des departements</h1>
           <input id="btnAddDep" type="button" class ="btn btn-success" value="Ajouter">
           <input id="filterDep" placeholder="filtre">
           <table class="table table-striped">
             <thead>
               <tr>
                 <th>Id</th>
                 <th>Nom</th>
                 <th>Numero</th>
                 <th>Region</th>
                 </tr>
             </thead>
             <tbody id="contentTable">
            	 <c:forEach items="${departement}" var="departement">
					<tr>
						<td>${departement.id}</td>
						<td>${departement.nom}</td>
						<td>${departement.numero}</td>
						<td>${departement.region}</td>
						<td>
                   			<input onclick="updateDep(${departement.id},'${departement.nom}','${departement.numero}','${departement.region}')" type="button" class ="btn btn-warning" value="Modifier">
                   			<input onclick="deleteDep(${departement.id})" type="button" class ="btn btn-danger" value="Supprimer">
                		 </td>
					</tr>
				</c:forEach>
     
             </tbody>
           </table>


      <div id="addFormDep">
             <h3>Ajouter nouveau Departement</h3>
             <form action="departement" method="post">
             	<input type="hidden" name="type_form" value="POST">
              <label for="add_nom">Nom :</label> <input required id="add_nom" name="nom" type="text" placeholder="Saisir le nom"><br>
               <label for="add_numero">Numero :</label> <input required id="add_numero" name="numero" type="text" placeholder="Saisir votre numero"><br>
               <select id="add_region" name="region">
                   <option value="choose" selected="selected">Choisir une Region</option>
                   <option value="Auvergne_Rhône_Alpes">1-Auvergne_Rhone_Alpes</option>
					<option value="Bourgogne_Franche_Comté">2-Bourgogne_Franche_Comté</option>
					<option value="Bretagne">3-Bretagne</option>
				    <option value="Centre_Val_de_Loire">4-Centre_Val_de_Loire</option>
                   <option value="Corse">5-Corse</option>
                   <option value="Grand-Est">6-Grand-Est</option>
                   <option value="Haut_de_France">7-Haut_de_France</option>
                   <option value="Ile_de_France">8-Ile_de_France</option>
                   <option value="Normandie">9-Normandie</option>
                   <option value="Nouvelle_Aquitaine">10-Nouvelle_Aquitaine</option>
                   <option value="Occitanie">11-Occitanie</option>
                   <option value="Pays_de_la_Loire">12-Pays_de_la_Loire</option>
                   <option value="Provence_Alpes_Côte_d_Azur">13-Provence_Alpes_Cote_d_azur</option>
                   <option value="Guadeloupe">14-Guadeloupe</option>
                   <option value="Martinique">15-Martinique</option>
                   <option value="Guyane">16-Guyane</option>
                   <option value="Reunion">17-La_Reunion</option>
                   <option value="Mayotte">18-Mayotte</option>
               </select><br>

               <input class ="btn btn-success" type="submit" name="ajouter" value="Ajouter">
             </form>
         </div>

           <div id="updateFormDep">
             <h3>Modifier le Departement</h3>
            
			<form action="departement" method="post">
             	<input type="hidden" id="update_id_dep" name="id">  
             	<input type="hidden" name="type_form" value="PUT">

                <label for="update_nom">Nom :</label> <input required id="update_nom" name="nom" value="nom" type="text" placeholder="Saisir le nom"><br>
               <label for="update_numero">Numéro :</label> <input required id="update_numero" name="numero" type="text" placeholder="Saisir le numéro"><br>
               <select id="update_region" name="region" value="region" selected="selected">
                 <option value="Auvergne_Rhône_Alpes">1-Auvergne_Rhone_Alpes</option>
                 <option value="Bourgogne_Franche_Comté">2-Bourgogne_Franche_Comté</option>
                 <option value="Bretagne">3-Bretagne</option>
                 <option value="Centre_Val_de_Loire">4-Centre_Val_de_Loire</option>
                 <option value="Corse">5-Corse</option>
                 <option value="Grand_Est">6-Grand-Est</option>
                 <option value="Haut_de_France">7-Haut_de_France</option>
                 <option value="Ile_de_France">8-Ile_de_France</option>
                 <option value="Normandie">9-Normandie</option>
                 <option value="Nouvelle_Aquitaine">10-Nouvelle_Aquitaine</option>
                 <option value="Occitanie">11-Occitanie</option>
                 <option value="Pays_de_la_Loire">12-Pays_de_la_Loire</option>
                 <option value="Provence_Alpes_Côte_d_Azur">13-Provence_Alpes_Cote_d_azur</option>
                 <option value="Guadeloupe">14-Guadeloupe</option>
                 <option value="Martinique">15-Martinique</option>
                 <option value="Guyane">16-Guyane</option>
                 <option value="Reunion">17-La_Reunion</option>
                 <option value="Mayotte">18-Mayotte</option>
               </select><br>
               <input class ="btn btn-warning" type="submit" name="modifier" value="Modifier">
             </form>
           </div>
           <a href="admin.html">Retour</a>
         </div>
    </div>
  </div>


<script>

filterDep.onkeyup=filtreAjax;

btnAddDep.onclick=function()
{
	updateFormDep.style.display="none";
	addFormDep.style.display="block";
}

function updateDep(id,nom,numero,region)
{
		
	addFormDep.style.display="none";
	updateFormDep.style.display="block";

	update_nom.value=nom;
	update_numero.value=numero;
	update_region.setAttribute("selected",region);
	update_id_dep.value=id;
	
}



function deleteDep(id)
{
	if(confirm("Etes vous sur de vouloir supprimer ce departement ?"))
	{
		$.ajax("departement", {
			type: "POST",
			data: 
			{
				id : id,
				type_form:"DELETE"
			},
			success: function (resp) {
				location.href="departement";
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
			search : filterDep.value,
			page:"departement"
		},
		success: function (resp) {
			contentTable.innerHTML=resp;
		}
	});
}


</script>
</body>
</html>