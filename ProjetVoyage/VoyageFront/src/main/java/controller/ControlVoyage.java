package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IDAOTrajet;
import dao.IDAOTransport;
import dao.IDAOVoyage;
import metier.Trajet;
import metier.Transport;
import metier.Voyage;
import util.Context;

@WebServlet("/voyage")
public class ControlVoyage extends HttpServlet {
       
	private IDAOVoyage daov = Context.getInstance().getDaoVo();
	private IDAOTrajet daot =Context.getInstance().getDaoT();
	private IDAOTransport daoTr = Context.getInstance().getDaoTransport();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Voyage> v = daov.findAll();
		List<Trajet> t = daot.findAll();
		List<Transport> transports = daoTr.findAll();
		request.setAttribute("transports", transports);
        request.setAttribute("trajets", t);
		request.setAttribute("voyages", v);
		
		this.getServletContext().getRequestDispatcher("/voyages.jsp").forward(request, response);
		
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
			Voyage v=null;
			
			Trajet trajet = daot.findById( Integer.parseInt(request.getParameter("id_trajet")));
			Transport transport = daoTr.findByLibelle(request.getParameter("id_transport"));
			v=new Voyage(trajet ,transport, Integer.parseInt(request.getParameter("duree")));
			

			daov.insert(v);

			
		}
		doGet(request, response);

	}
	protected void doPut(HttpServletRequest request) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id_voy"));


		Voyage v=null;

		Trajet trajet = daot.findById( Integer.parseInt(request.getParameter("id_trajet")));
		Transport transport = daoTr.findByLibelle(request.getParameter("id_transport"));
		v=new Voyage(id, trajet ,transport, Integer.parseInt(request.getParameter("duree")));
		
	

		daov.update(v);
	}

	protected void doDelete(HttpServletRequest request) throws ServletException, IOException {

		daov.delete(Integer.parseInt(request.getParameter("id")));
	}

}
