package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Utilisateur;
import Dao.DAOFactory;
import Dao.UtilisateurDAO;
import forms.TraiterFormRechrcherUtilisateur;

/**
 * Servlet implementation class RechercheUtilisateur
 */
@WebServlet("/RechercheUtilisateur")
public class RechercheUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDAO utilisateurDAO;

	public void init() throws ServletException {
		this.utilisateurDAO = ((DAOFactory) getServletContext().getAttribute("daofactory")).getUtilisateurDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public RechercheUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = new TraiterFormRechrcherUtilisateur(utilisateurDAO).rechercheUtilisateur(request);
		request.setAttribute("profileUtilisateur", utilisateur);
		this.getServletContext().getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
	}

}
