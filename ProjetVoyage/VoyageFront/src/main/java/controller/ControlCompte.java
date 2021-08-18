package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc.DAOCompteJDBC;
import metier.Admin;
import metier.Client;
import metier.Compte;
import util.Context;


@WebServlet("/compte")
public class ControlCompte extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Compte> c = Context.getInstance().getDaoC().findAll();

		request.setAttribute("comptes", c);
		this.getServletContext().getRequestDispatcher("/comptes.jsp").forward(request, response);
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
			Compte c=null;
			if(request.getParameter("type_compte").equals("Client")) 
			{
				c=new Client(request.getParameter("login"), request.getParameter("password"));
			}
			else if(request.getParameter("type_compte").equals("Admin"))
				c = new Admin(request.getParameter("login"), request.getParameter("password"));
			Context.getInstance().getDaoC().insert(c);

			
		}
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));

		String login=request.getParameter("login");
		String password=request.getParameter("password");
		String typeCompte=request.getParameter("type_compte");

		Compte c=null;
		if(typeCompte.equals("Client")) 
		{
			c=new Client(id,login, password);
		}
		else if(typeCompte.equals("Admin"))
			c = new Admin(id,login,password);

		Context.getInstance().getDaoC().update(c);
	}

	protected void doDelete(HttpServletRequest request) throws ServletException, IOException {

		Context.getInstance().getDaoC().delete(Integer.parseInt(request.getParameter("id")));
	}



}
