package Dao;

import java.util.List;

import Beans.Utilisateur;

public interface UtilisateurDAO {
	
	
	Boolean Ajouter(Utilisateur utilisateur) throws DAOException;

	Utilisateur Connexion(String email, String motdepass) throws DAOException;

	List<Utilisateur> Afficher() throws DAOException;

	Boolean modifyUser(int id, String ancienMotdepass, String motdepass) throws DAOException;

	boolean suprimer(int id) throws DAOException;

	Utilisateur cherecherParEmail(String email) throws DAOException;

}
