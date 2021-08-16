package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCompte;
import metier.Admin;
import metier.Client;
import metier.Compte;


@WebServlet("/filter")
public class ControlFilter extends HttpServlet {

	private DAOCompte daoC = new DAOCompte();
	


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
		else if(request.getParameter("page").equals("trajet"))
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

	
	private void filterVoyage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void filterTrajet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void filterVille(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void filterDepartement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


}
