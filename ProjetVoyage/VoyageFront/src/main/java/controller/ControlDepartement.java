package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDAODepartement;
import metier.Departement;
import metier.Region;
import util.Context;

@WebServlet("/departement")
public class ControlDepartement extends HttpServlet {

	private IDAODepartement daoD = Context.getInstance().getDaoD();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Departement> d = daoD.findAll();

		request.setAttribute("departement", d);
		this.getServletContext().getRequestDispatcher("/departement.jsp").forward(request, response);
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
			String nom=request.getParameter("nom");
			String numero=request.getParameter("numero");
			String nomRegion=request.getParameter("region");

			System.out.println(nomRegion);
			Region region=Region.valueOf(nomRegion);
			
			Departement d = new Departement(nom, numero, region);
			daoD.insert(d);

			
		}
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));

		String nom=request.getParameter("nom");
		String numero=request.getParameter("numero");
		String nomRegion=request.getParameter("region");

		Region region=Region.valueOf(nomRegion);

		Departement d=new Departement(id, nom, numero, region);
		

		daoD.update(d);
	}

	protected void doDelete(HttpServletRequest request) throws ServletException, IOException {

		daoD.delete(Integer.parseInt(request.getParameter("id")));
	}

}
