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


@WebServlet("/compte")
public class ControlCompte extends HttpServlet {

	private DAOCompte daoC = new DAOCompte();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Compte> c = daoC.findAll();

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
			daoC.insert(c);

			
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

		daoC.update(c);
	}

	protected void doDelete(HttpServletRequest request) throws ServletException, IOException {

		daoC.delete(Integer.parseInt(request.getParameter("id")));
	}



}
