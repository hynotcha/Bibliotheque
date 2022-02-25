package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DAOFactory;
import Dao.UtilisateurDAO;
import forms.TraiterFormModifierMotdepass;

/**
 * Servlet implementation class ModiefierUtilisateur
 */
@WebServlet("/ModiefierUtilisateur")
public class ModiefierUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDAO utilisateurDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModiefierUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		this.utilisateurDAO = ((DAOFactory) getServletContext().getAttribute("daofactory")).getUtilisateurDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean modifierSuccess = new TraiterFormModifierMotdepass(utilisateurDAO).modifierMotdepass(request);
		if (modifierSuccess) {
			response.sendRedirect("/Biblio/Connexion");
		} else {
			request.setAttribute("error", "modfication n'est pas terminer ");
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierUtilisateur.jsp").forward(request,
					response);
		}
	}
}