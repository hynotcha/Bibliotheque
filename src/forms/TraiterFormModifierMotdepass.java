package forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Beans.Utilisateur;
import Dao.UtilisateurDAO;
import Tools.TraitementForms;

public class TraiterFormModifierMotdepass {
	private static final String ancienMotdepass = "ancienMotdepass";
	private static final String nouveauMotdepass = "nouveauMotdepass";
	private static final String champUtilisateur = "utilisateur";
	TraitementForms traitementForms = new TraitementForms();
	UtilisateurDAO utilisateurDAO;

	public TraiterFormModifierMotdepass(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	public boolean modifierMotdepass(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute(champUtilisateur);
		String ancienMotdepass1 = traitementForms.Champformulaire(request, ancienMotdepass);
		String nouveauMotdepass1 = traitementForms.Champformulaire(request, nouveauMotdepass);
		if (utilisateurDAO.modifyUser(utilisateur.getId(), ancienMotdepass1, nouveauMotdepass1)) {
			return true;
		} else {
			return false;
		}

	}

}
