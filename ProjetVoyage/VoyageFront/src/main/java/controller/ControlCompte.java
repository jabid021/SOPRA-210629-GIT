package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCompte;
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
		
		doGet(request, response);
	}

}
