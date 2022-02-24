package forms;

import javax.servlet.http.HttpServletRequest;

import Beans.Utilisateur;
import Dao.UtilisateurDAO;
import Tools.TraitementForms;

public class TraiterFormRechrcherUtilisateur {
	private static final String email = "email";
	private TraitementForms traitementForms = new TraitementForms();
	private UtilisateurDAO utilisateurDAO;

	public TraiterFormRechrcherUtilisateur(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	public Utilisateur rechercheUtilisateur(HttpServletRequest request) {
		String emailLocal = traitementForms.Champformulaire(request, email);
		Utilisateur utilisateur = utilisateurDAO.cherecherParEmail(emailLocal);
		return utilisateur;
	}

}
