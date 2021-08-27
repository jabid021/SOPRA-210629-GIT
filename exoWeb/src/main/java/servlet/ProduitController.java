package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eshop.model.Produit;

/**
 * Servlet implementation class ProduitController
 */
@WebServlet("/produit")
public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProduitController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/produit/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String idString = request.getParameter("id");
		String prixString = request.getParameter("prix");
		int id = 0;
		double prix = 0;
		boolean error = false;
		RequestDispatcher rd = null;
		if (nom == null || nom.isEmpty()) {
			error = true;
		}
		if (idString == null) {
			error = true;
		} else {
			try {
				id = Integer.parseInt(idString);
			} catch (NumberFormatException e) {
				error = true;
			}
		}
		if (prixString == null) {
			error = true;
		} else {
			try {
				prix = Double.parseDouble(prixString);
			} catch (NumberFormatException e) {
				error = true;
			}
		}

		if (error) {
			// retour vers formulaire
			rd = request.getRequestDispatcher("WEB-INF/produit/edit.jsp?error=error");
			//request.setAttribute("error", true);
		} else {
			// affichage du produit
			request.setAttribute("produit", new Produit(nom, prix, null));
			rd = request.getRequestDispatcher("WEB-INF/produit/info.jsp");
		}
		rd.forward(request, response);
	}

}
