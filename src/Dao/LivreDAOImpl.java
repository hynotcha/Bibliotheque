package Dao;
import static Dao.DAOUtils.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Livre;

public class LivreDAOImpl implements LivreDAO {

	private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Livre WHERE id = ?";
	private static final String SQL_INSERT        = "INSERT INTO Commande (id_client, date, montant) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE_PAR_ID = "DELETE FROM Commande WHERE id = ?";
	
	private DAOFactory daofactory;
	
	LivreDAOImpl(DAOFactory daofact){
		this.daofactory=daofact;
	}
	
	
	
	@Override
	public void Ajouterlivre(Livre livre) throws IllegalArgumentException, DAOException {
		
	}

	@Override
	public Livre trouver(Long id) throws  DAOException {
		
	
		return trouver(SQL_SELECT_PAR_ID, id);
	}

	
	
	
	
	
/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	private Livre trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Livre livre = null;

        try {
            /* R�cup�ration d'une connexion depuis la Factory */
            connexion = daofactory.getConnection();
            /*
             * Pr�paration de la requ�te avec les objets pass�s en arguments
             * (ici, uniquement un id) et ex�cution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de donn�es retourn�e dans le ResultSet */
            if ( resultSet.next() ) {
                livre = resultat( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return livre;
    }

/*________________________________________________________________________________________________________________________________________________________________________________________________________________*/

	private static Livre resultat(ResultSet resultset) throws SQLException {
		Livre livre=new Livre();
		livre = resultset.unwrap(Livre.class);
		
		
		return livre;
	}

}
