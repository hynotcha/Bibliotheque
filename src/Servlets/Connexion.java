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
import Tools.UtilisateurUtil;
import forms.TraiterFormConnexion;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDAO utilisateurDAO;

	public void init() throws ServletException {
		this.utilisateurDAO = ((DAOFactory) getServletContext().getAttribute("daofactory")).getUtilisateurDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TraiterFormConnexion traiterFormConnexion = new TraiterFormConnexion(utilisateurDAO);
		System.out.println("in the do post");
		Utilisateur utilisateur = traiterFormConnexion.Connexion(request);
		if (utilisateur != null) {
			UtilisateurUtil.ajouterUtilisateurSession(request, response, utilisateur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/accuile.jsp").forward(request, response);
		} else {
			System.out.println("in the else");
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);

		}

	}

}
