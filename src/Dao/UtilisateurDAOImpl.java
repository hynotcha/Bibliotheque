package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Utilisateur;
import Tools.PasswordHash;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	private static final String SQL_SELECT_PAR_Email_MOTDEPASS = "SELECT * FROM utilisateur WHERE email = ? and motdepass= ? ";
	private static final String SQL_UPDATE = "UPDATE utilisateur SET `motdepass` =? WHERE (id=? and motdepass = ?);";
	private static final String SQL_SELECT_PAR_Email = "SELECT * FROM utilisateur WHERE email = ? ";
	private static final String SQL_INSERT = "INSERT INTO utilisateur (nom , prenom , email,motdepass,role) VALUES (?,?,?,?,?)";
	private static final String SQL_SELECT_ALL = "SELECT * FROM utilisateur ";
	private static final String SQL_DELETE_PAR_ID = "DELETE * FROM utilisateur WHERE id =? ";
	private DAOFactory daofactory;
	Connection connexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public UtilisateurDAOImpl(DAOFactory daofactory) {
		this.daofactory = daofactory;
	}

	@Override
	public Boolean Ajouter(Utilisateur utilisateur) throws DAOException {
		// TODO Auto-generated method stub
		try {
			connexion = daofactory.getConnection();
			preparedStatement = DAOUtils.initialisationRequetePreparee(connexion, SQL_INSERT, true,
					utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getMotdepass(),
					utilisateur.getRole());
			int status = preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			System.out.println(resultSet.getInt("id"));

			connexion.commit();
		
			if (status == 0) {
				throw new DAOException("echec de l'insertion");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			DAOUtils.fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return true;
	}

	@Override
	public Utilisateur Connexion(String email, String motdepass) throws DAOException {
		// TODO Auto-generated method stub
		try {

			connexion = daofactory.getConnection();
			preparedStatement = DAOUtils.initialisationRequetePreparee(connexion, SQL_SELECT_PAR_Email_MOTDEPASS, true,
					email, PasswordHash.motdepassHash(motdepass));
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Utilisateur utilisateur = new Utilisateur(resultSet.getInt("id"), resultSet.getString("nom"),
						resultSet.getString("prenom"), resultSet.getString("email"), resultSet.getString("motdepass"),
						resultSet.getString("role"));
				return utilisateur;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAOUtils.fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
		return null;

	}

	@Override
	public List<Utilisateur> Afficher() throws DAOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Utilisateur> utilisateurList = null;
		try {
			utilisateurList = new ArrayList<Utilisateur>();
			connexion = daofactory.getConnection();
			preparedStatement = DAOUtils.initialisationRequetePreparee(connexion, SQL_SELECT_ALL, true);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("nom"));
				Utilisateur utilisateur = new Utilisateur(resultSet.getInt("id"), resultSet.getString("nom"),
						resultSet.getString("prenom"), resultSet.getString("email"), null, resultSet.getString("role"));
				utilisateurList.add(utilisateur);
				utilisateur = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAOUtils.fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
		return utilisateurList;
	}

	@Override
	public Boolean modifyUser(int id, String ancienMotdepass, String nouveauMotdepass) throws DAOException {
		try {
			connexion = daofactory.getConnection();
			preparedStatement = DAOUtils.initialisationRequetePreparee(connexion, SQL_UPDATE, true, nouveauMotdepass,
					id, ancienMotdepass);
			int status = preparedStatement.executeUpdate();
			connexion.commit();
			if (status == 0) {
				return false;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			DAOUtils.fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return true;
	}

	@Override
	public boolean suprimer(int id) throws DAOException {
		try {
			connexion = daofactory.getConnection();
			preparedStatement = DAOUtils.initialisationRequetePreparee(connexion, SQL_DELETE_PAR_ID, true, id);
			int status = preparedStatement.executeUpdate();
			connexion.commit();
			if (status == 0) {
				throw new DAOException("User password is wrong");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			DAOUtils.fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return true;
	}

	@Override
	public Utilisateur cherecherParEmail(String email) throws DAOException {
		// TODO Auto-generated method stub
		try {

			connexion = daofactory.getConnection();
			preparedStatement = DAOUtils.initialisationRequetePreparee(connexion, SQL_SELECT_PAR_Email, true, email);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Utilisateur utilisateur = new Utilisateur(resultSet.getInt("id"), resultSet.getString("nom"),
						resultSet.getString("prenom"), resultSet.getString("email"), null, resultSet.getString("role"));
				return utilisateur;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAOUtils.fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return null;
	}

}
