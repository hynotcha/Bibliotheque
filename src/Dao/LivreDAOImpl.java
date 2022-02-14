package Dao;
import static Dao.DAOUtils.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Beans.Livre;

public class LivreDAOImpl implements LivreDAO {

	private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Livre WHERE id = ?";
	private static final String SQL_INSERT        = "INSERT INTO Livre (auteur, titre, type, edition, consult, nbpage, prix, date) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
	private static final String SQL_DELETE_PAR_ID = "DELETE FROM Commande WHERE id = ?";
	
	private DAOFactory daofactory;
	
	LivreDAOImpl(DAOFactory daofact){
		this.daofactory=daofact;
	}
	
	
	
	@Override
	public void Ajouterlivre(Livre livre) throws IllegalArgumentException, DAOException {
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
		
        try {
        	connexion =daofactory.getConnection();
        	preparedStatement =initialisationRequetePreparee(connexion,SQL_INSERT, true, livre.getAuteur(),livre.getTitre(), livre.getType(),
        			livre.getEdition(),livre.getConsult(),livre.getNbpage(),livre.getPrix(),livre.getDate());
        	System.out.println("ajout du liiivre ");
        	
        	int status= preparedStatement.executeUpdate();
        	System.out.println("____excute update ______"+status);
        	if(status==0) {throw new DAOException ("echec de l'insertion");}
        	
        }
        catch (SQLException e) { 
        	System.out.println(e);
        	throw new DAOException(e);
        } finally {
        	fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
	}

	@Override
	public Livre trouver(Long id) throws  DAOException {
		
	System.out.println("hna raw f trouver lewla");
		return trouver(SQL_SELECT_PAR_ID, id);
	}

	@Override
	public List<Livre> Afficher() throws DAOException {
		
		return null;
	}
	
	
	
	@Override
	public List<Livre> Chercher() throws DAOException {
		
		return null;
	}
	
	@Override
	public void modifier() throws DAOException {
		
		
	}
	
	
	@Override
	public void supprimer() throws DAOException {
		
		
	}
	
	
/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	private Livre trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Livre livre = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daofactory.getConnection();
            System.out.println("recupira dao");
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            System.out.println("excuta query");
            System.out.println(resultSet.toString()+"  ya333 "+ resultSet.findColumn("auteur")+resultSet.next());
          //  System.out.println(resultSet.getBoolean(1)+"   "+resultSet.getFetchSize() + resultSet.getString(2));
            /* Parcours de la ligne de données retournée dans le ResultSet */
            if ( resultSet.next() ) {
            	System.out.println("rahouQ f next");
                livre = resultat( resultSet );
            }
            System.out.println("ki yokhrej mel if");
        } catch ( SQLException e ) {
        	
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return livre;
    }

	
	
	
	
/*________________________________________________________________________________________________________________________________________________________________________________________________________________*/

	private static Livre resultat(ResultSet resultset) throws SQLException {
		System.out.println("raw fel resultat");
		Livre livre=new Livre();
		System.out.println("fel unwrapp");
		livre = resultset.unwrap(Livre.class);
		
		
		return livre;
	}

}
