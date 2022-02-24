package forms;

import javax.servlet.http.HttpServletRequest;

import Beans.Utilisateur;
import Dao.UtilisateurDAO;
import Tools.PasswordHash;
import Tools.TraitementForms;

public class TraiterFormInscrire {
	private static final String nom = "nom";
	private static final String prenom = "prenom";
	private static final String email = "email";
	private static final String motdepass = "motdepass";
	private static final String role = "role";
	private TraitementForms traitementForms = new TraitementForms();
	private UtilisateurDAO utilisateurDao;

	public TraiterFormInscrire(UtilisateurDAO utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	public Utilisateur ajouterUtilisateur(HttpServletRequest request) {
		String nom1 = traitementForms.Champformulaire(request, nom);
		String prenom1 = traitementForms.Champformulaire(request, prenom);
		String email1 = traitementForms.Champformulaire(request, email);
		String motdepass1 = traitementForms.Champformulaire(request, motdepass);
		String role1 = traitementForms.Champformulaire(request, role);
		Utilisateur utilisateur = new Utilisateur(nom1, prenom1, email1, PasswordHash.motdepassHash(motdepass1), role1);
		boolean si_Ajouter = utilisateurDao.Ajouter(utilisateur);
		if (si_Ajouter) {
			return utilisateur;
		} else {
			return null;
		}

	}
}
