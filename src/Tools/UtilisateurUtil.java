package Tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Utilisateur;

public class UtilisateurUtil {
	private static final String utilisateurChamp = "utilisateur";

	public static boolean VérifierSiUtilisateurConnect(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute(utilisateurChamp);
		if (utilisateur != null) {
			return true;
		} else {
			return false;
		}

	}

	public static void ajouterUtilisateurSession(HttpServletRequest request, HttpServletResponse response,
			Utilisateur utilisateur) {
		HttpSession session = request.getSession();
		session.setAttribute(utilisateurChamp, utilisateur);

	}

	public static void supprimerUtilisateurSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();

	}
}
