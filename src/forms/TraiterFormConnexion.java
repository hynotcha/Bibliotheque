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
		String email1 = traitementForms.Champformulaire(request,email);
		String motdepass1 = traitementForms.Champformulaire(request, motdepass);
		Utilisateur utilisateur = utilisateurDAO.Connexion(email1, motdepass1);
		return utilisateur;
	}

}
