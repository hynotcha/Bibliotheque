package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Utilisateur;
import Dao.DAOFactory;
import Dao.UtilisateurDAO;

/**
 * Servlet implementation class ListUtilisateur
 */
@WebServlet("/ListUtilisateur")
public class ListUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDAO utilisateurDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() throws ServletException {
		this.utilisateurDAO = ((DAOFactory) getServletContext().getAttribute("daofactory")).getUtilisateurDao();
	}

	public ListUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Utilisateur> utilisateurList = utilisateurDAO.Afficher();
		request.setAttribute("utilisateurList", utilisateurList);
		this.getServletContext().getRequestDispatcher("/WEB-INF/listUtilisateur.jsp").forward(request, response);

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
