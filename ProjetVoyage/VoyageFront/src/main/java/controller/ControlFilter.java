package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDAOCompte;
import dao.IDAODepartement;
import dao.IDAOTrajet;
import dao.IDAOVille;
import dao.IDAOVoyage;
import metier.Compte;
import metier.Departement;
import metier.Trajet;
import metier.Ville;
import metier.Voyage;
import util.Context;


@WebServlet("/filter")
public class ControlFilter extends HttpServlet {

	private IDAOCompte daoC = Context.getInstance().getDaoC();
	private IDAODepartement daoD = Context.getInstance().getDaoD();
	private IDAOVille daoVi = Context.getInstance().getDaoVi();
	private IDAOVoyage daoVo = Context.getInstance().getDaoVo();
	private IDAOTrajet daoT = Context.getInstance().getDaoT();
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("page").equals("compte"))
		{
			filterCompte(request,response);
		}
		else if(request.getParameter("page").equals("departement"))
		{
			filterDepartement(request,response);
		}
		else if(request.getParameter("page").equals("ville"))
		{
			filterVille(request,response);
		}
		else if(request.getParameter("page").equals("trajets"))
		{
			filterTrajet(request,response);
		}
		else if(request.getParameter("page").equals("voyage"))
		{
			filterVoyage(request,response);
		}
		
	}

	



	private void filterCompte(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String mot = request.getParameter("search");
		List<Compte> comptes = daoC.filterCompte(mot);
		for(Compte c : comptes ) 
		{
		
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+c.getId()+"</td>");
			response.getWriter().println("<td>"+c.getLogin()+"</td>");
			response.getWriter().println("<td>"+c.getPassword()+"</td>");
			response.getWriter().println("<td>"+c.getClass().getSimpleName()+"</td>");
			response.getWriter().println("<td>");
			response.getWriter().println("<input onclick=\"updateCompte("+c.getId()+",'"+c.getLogin()+"','"+c.getPassword()+"','"+c.getClass().getSimpleName()+"')\" type=\"button\" class =\"btn btn-warning\" value=\"Modifier\">");
			response.getWriter().println("<input onclick=\"deleteCompte("+c.getId()+")\" type=\"button\" class =\"btn btn-danger\" value=\"Supprimer\">");
			response.getWriter().println("</td>");
			response.getWriter().println("</tr>");
		}
		
		if(comptes.isEmpty()) 
		{
			response.getWriter().println("<tr><td align='center' colspan='5'>Aucun resultat</td></tr>");
		}
		
		
	}

	
	private void filterVoyage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mot = request.getParameter("search");
		List<Voyage> voyages = daoVo.filterVoyage(mot);
		for(Voyage v : voyages ) 
		{
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+v.getId()+"</td>");
			response.getWriter().println("<td>"+v.getDureeSejour() +"</td>");
			response.getWriter().println("<td>"+v.getTrajet().getDepart().getNom()+"-"+v.getTrajet().getDestination().getNom()+"</td>");
			response.getWriter().println("<td>"+v.getTransport()+"</td>");
			response.getWriter().println("<td class='d-flex justify-content-around'>");
			response.getWriter().println("</td>");
			response.getWriter().println("</tr>");
		}
		if(voyages.isEmpty()) 
		{
			response.getWriter().println("<tr><td align='center' colspan='5'>Aucun resultat</td></tr>");
		}
	}


	private void filterTrajet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("test");
		String mot = request.getParameter("search");
		List<Trajet> trajets = daoT.filterTrajet(mot);
		for(Trajet t : trajets ) 
		{
			System.out.println(t);
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+t.getId()+"</td>");
			response.getWriter().println("<td>"+t.getDistance()+"</td>");
			response.getWriter().println("<td>"+t.getDepart().getNom()+"</td>");
			response.getWriter().println("<td>"+t.getDestination().getNom()+"</td>");
			response.getWriter().println("<td>");
			response.getWriter().println("<input onclick=\"updateTrajet("+t.getDistance()+",'"+t.getDepart().getId()+"','"+t.getDestination().getId()+"')\" type=\"button\" class =\"btn btn-warning\" value=\"Modifier\">");
			response.getWriter().println("<input onclick=\"deleteTrajet("+t.getId()+")\" type=\"button\" class =\"btn btn-danger\" value=\"Supprimer\">");
			response.getWriter().println("</td>");
			response.getWriter().println("</tr>");
		}
		
		if(trajets.isEmpty()) 
		{
			response.getWriter().println("<tr><td align='center' colspan='5'>Aucun resultat</td></tr>");
		}
		
	}


	private void filterVille(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mot = request.getParameter("search");
		List<Ville> villes = daoVi.filterVille(mot);
		for(Ville v : villes ) 
		{
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+v.getId()+"</td>");
			response.getWriter().println("<td>"+v.getNom()+"</td>");
			response.getWriter().println("<td>"+v.getCarac()+"</td>");
			response.getWriter().println("<td>"+v.getDepartement().getNom()+"</td>");
			response.getWriter().println("<td>");
			response.getWriter().println("<input onclick=\"updateVille("+v.getId()+",'"+v.getNom()+"','"+v.getCarac()+"','"+v.getDepartement().getId()+"')\" type=\"button\" class =\"btn btn-warning\" value=\"Modifier\">");
			response.getWriter().println("<input onclick=\"deleteVille("+v.getId()+")\" type=\"button\" class =\"btn btn-danger\" value=\"Supprimer\">");
			response.getWriter().println("</td>");
			response.getWriter().println("</tr>");
		}
		
		if(villes.isEmpty()) 
		{
			response.getWriter().println("<tr><td align='center' colspan='5'>Aucun resultat</td></tr>");
		}
	}


	private void filterDepartement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mot = request.getParameter("search");
		List<Departement> departement = daoD.filterDepartement(mot);
		for(Departement d : departement ) 
		{
		
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+d.getId()+"</td>");
			response.getWriter().println("<td>"+d.getNom()+"</td>");
			response.getWriter().println("<td>"+d.getNumero()+"</td>");
			response.getWriter().println("<td>"+d.getRegion()+"</td>");
			response.getWriter().println("<td>");
			response.getWriter().println("<input onclick=\"updateDepartement("+d.getId()+",'"+d.getNom()+"','"+d.getNumero()+"','"+d.getRegion()+"')\" type=\"button\" class =\"btn btn-warning\" value=\"Modifier\">");
			response.getWriter().println("<input onclick=\"deleteDepartement("+d.getId()+")\" type=\"button\" class =\"btn btn-danger\" value=\"Supprimer\">");
			response.getWriter().println("</td>");
			response.getWriter().println("</tr>");
		}
	}


}
