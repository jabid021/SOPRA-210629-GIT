package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import eshop.model.Produit;
import eshop.repositories.ProduitRepository;

/**
 * Servlet implementation class CrudProduitController
 */
@WebServlet("/crudproduit")
public class CrudProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrudProduitController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String q = request.getParameter("q");
		if (q == null) {
			rd = list(request, response);
		} else if (q.equals("add")) {
			rd = add(request, response);
		} else if (q.equals("save")) {
			rd = save(request, response);
		} else if (q.equals("delete")) {
			rd = delete(request, response);
		} else if (q.equals("edit")) {
			rd = edit(request, response);
		}

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		ProduitRepository produitRepo = ((ApplicationContext) getServletContext().getAttribute("spring"))
				.getBean(ProduitRepository.class);
		request.setAttribute("produits", produitRepo.findAll());
		return request.getRequestDispatcher("WEB-INF/produit/list.jsp");
	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {
		boolean error = false;
		String nom = null;
		if (request.getParameter("nom") == null || request.getParameter("nom").isEmpty()) {
			error = true;
		} else {
			nom = request.getParameter("nom");
		}
		double prix = 0;
		if (request.getParameter("prix") == null || request.getParameter("prix").isEmpty()) {
			error = true;
		} else {
			try {
				prix = Double.parseDouble(request.getParameter("prix"));
			} catch (NumberFormatException e) {
				error = true;
			}
		}

		Integer id = null;
		if (!request.getParameter("id").isEmpty()) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		Produit produit = new Produit(id, nom, prix, null);
		if (error) {
			request.setAttribute("donneeIncorrectes", true);
			return goEdit(produit, request, response);
		}

		ProduitRepository produitRepo = ((ApplicationContext) getServletContext().getAttribute("spring"))
				.getBean(ProduitRepository.class);
		produitRepo.save(produit);
		return list(request, response);
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		ProduitRepository produitRepo = ((ApplicationContext) getServletContext().getAttribute("spring"))
				.getBean(ProduitRepository.class);
		int id = Integer.parseInt(request.getParameter("id"));
		produitRepo.deleteById(id);
		request.setAttribute("delete", id);
		return list(request, response);
	}

	private RequestDispatcher add(HttpServletRequest request, HttpServletResponse response) {
		return goEdit(new Produit(), request, response);
	}

	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		ProduitRepository produitRepo = ((ApplicationContext) getServletContext().getAttribute("spring"))
				.getBean(ProduitRepository.class);
		int id = Integer.parseInt(request.getParameter("id"));
		Produit produit = produitRepo.findById(id).get();
		return goEdit(produit, request, response);
	}

	private RequestDispatcher goEdit(Produit produit, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("produit", produit);
		return request.getRequestDispatcher("WEB-INF/produit/edit.jsp");
	}
}
