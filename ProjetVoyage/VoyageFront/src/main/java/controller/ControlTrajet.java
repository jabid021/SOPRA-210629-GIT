package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDAOTrajet;
import dao.IDAOVille;
import metier.Trajet;
import metier.Ville;
import util.Context;

@WebServlet("/trajets")
public class ControlTrajet extends HttpServlet {
	
	private IDAOTrajet daoT = Context.getInstance().getDaoT();
	private IDAOVille daoV = Context.getInstance().getDaoVi();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Trajet> t = daoT.findAll();
		List<Ville> v = daoV.findAll();

		request.setAttribute("trajets", t);
		request.setAttribute("villes", v);
		this.getServletContext().getRequestDispatcher("/trajets.jsp").forward(request, response);
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
			
			Ville depart=daoV.findById(Integer.parseInt(request.getParameter("id_depart")));
			Ville destination=daoV.findById(Integer.parseInt(request.getParameter("id_destination")));
			
			Trajet t = new Trajet(depart,destination,Double.parseDouble(request.getParameter("distance")));
			
			daoT.insert(t);
						
		}
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		int id=Integer.parseInt(request.getParameter("id"));

		System.out.println(request.getParameter("id_depart"));
		Ville depart=daoV.findById(Integer.parseInt(request.getParameter("id_depart")));
		Ville destination=daoV.findById(Integer.parseInt(request.getParameter("id_destination")));
		Trajet t = new Trajet(id,depart,destination,Double.parseDouble(request.getParameter("distance")));

		daoT.update(t);
	}

	protected void doDelete(HttpServletRequest request) throws ServletException, IOException {

		daoT.delete(Integer.parseInt(request.getParameter("id")));
	}
}
