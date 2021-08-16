package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDAOVille;
import metier.Departement;
import metier.Ville;
import util.Context;




@WebServlet("/villes")
public class ControlVilles extends HttpServlet{
	
	private IDAOVille daoV = Context.getInstance().getDaoVi();
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Ville> v = daoV.findAll();

		request.setAttribute("ville", v);
		this.getServletContext().getRequestDispatcher("/ville.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("type_form").equals("PUT"))
		{
			doPut(request);
		}
		else if(request.getParameter("type_form").equals("DELETE"))
		{
			doDelete(request);
		}
		else if(request.getParameter("type_form").equals("POST"))
		{
			Departement d = new Departement(Integer.parseInt(request.getParameter("dept")));
			Ville v=new Ville(request.getParameter("nom_ville"), request.getParameter("caractere"), d);
			daoV.insert(v);	
		}
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id_ville"));
		String nom=request.getParameter("nom_ville");
		String caractere=request.getParameter("caractere");
		Departement d = new Departement(Integer.parseInt(request.getParameter("dept")));
		Ville v=new Ville(id,request.getParameter("nom_ville"), request.getParameter("caractere"), d);
		
		System.out.println(v);

		daoV.update(v);
	}

	protected void doDelete(HttpServletRequest request) throws ServletException, IOException {

		daoV.delete(Integer.parseInt(request.getParameter("id")));
	}


}
