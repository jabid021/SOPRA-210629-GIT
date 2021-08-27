package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(urlPatterns = { "/home", "/page1" }, initParams = { @WebInitParam(name = "prenom", value = "olivier"),
		@WebInitParam(name = "nom", value = "gozlan") })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<!DOCTYPE html>");
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>Ma première page</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<p>Allô le monde ?!</p>");
		response.getWriter().println("<p>Bonjour " + request.getParameter("user") + "</p>");
		ServletConfig servletConfig = this.getServletConfig();
		response.getWriter().println("<p>parametre init " + servletConfig.getInitParameter("prenom") + "</p>");

		response.getWriter().println("</body>");
		response.getWriter().println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
