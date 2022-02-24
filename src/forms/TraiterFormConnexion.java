package forms;

import javax.servlet.http.HttpServletRequest;

import Beans.Utilisateur;
import Dao.UtilisateurDAO;
import Tools.TraitementForms;

public class TraiterFormConnexion {
	private static final String email = "email";
	private static final String motdepass = "motdepass";

	private TraitementForms traitementForms = new TraitementForms();
	private UtilisateurDAO utilisateurDAO;

	public TraiterFormConnexion(UtilisateurDAO utilisateurDAO) {

		this.utilisateurDAO = utilisateurDAO;
	}

	public Utilisateur Connexion(HttpServletRequest request) {
		String email = traitementForms.Champformulaire(request, this.email);
		String motdepass = traitementForms.Champformulaire(request, this.motdepass);
		Utilisateur utilisateur = utilisateurDAO.Connexion(email, motdepass);
		return null;
	}

}
