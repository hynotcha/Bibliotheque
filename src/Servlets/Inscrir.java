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
import forms.TraiterFormInscrire;

/**
 * Servlet implementation class Inscrir
 */
@WebServlet("/Inscrir")
public class Inscrir extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UtilisateurDAO utilisateurDao;

	public void init() throws ServletException {
		this.utilisateurDao = ((DAOFactory) getServletContext().getAttribute("daofactory")).getUtilisateurDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscrir() {

		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (UtilisateurUtil.VérifierSiUtilisateurConnect(request)) {
			response.sendRedirect("/Biblio/Accuile");
		} else {

			this.getServletContext().getRequestDispatcher("/WEB-INF/inscrir.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		TraiterFormInscrire traiterFormInscrire = new TraiterFormInscrire(utilisateurDao);
		Utilisateur utilisateur = traiterFormInscrire.ajouterUtilisateur(request);//return utilisateur
		if (utilisateur != null) {
			UtilisateurUtil.ajouterUtilisateurSession(request, response, utilisateur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/accuile.jsp").forward(request, response);
		} else {
			response.sendRedirect("/Biblio/Inscrir");
		}

	}

}
