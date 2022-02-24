package Dao;
import static Dao.DAOUtils.fermeturesSilencieuses;
import static Dao.DAOUtils.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Livre;

public class LivreDAOImpl implements LivreDAO {

	private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Livre WHERE id = ?";
	private static final String SQL_INSERT        = "INSERT INTO bibliotheque.Livre (titre, auteur, type, edition, consult, nbpage, prix, date, pdf) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
	private static final String SQL_DELETE_PAR_ID = "DELETE FROM Livre WHERE id = ?";
	private static final String SQL_SELECT_koulach="SELECT *FROM Livre";
	private static final String SQL_SELECT_PAR_haja="SELECT *FROM Livre WHERE ? = ?";
	private DAOFactory daofactory;
	
	LivreDAOImpl(DAOFactory daofact){
		this.daofactory=daofact;
	}
	
	
	
	@Override
	public void Ajouterlivre(Livre livre) throws Exception {
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
		
        try {
        	connexion =daofactory.getConnection();
        	preparedStatement =initialisationRequetePreparee(connexion,SQL_INSERT, true, livre.getTitre(),livre.getAuteur(), livre.getType(),
        			livre.getEdition(),livre.getConsult(),livre.getNbpage(),livre.getPrix(),livre.getDate(), livre.getPdf());
        	System.out.println("ajout du liiivre ");
        	
        	
        	int status= preparedStatement.executeUpdate();
        	connexion.commit();

        	System.out.println("____excute update ______"+status);

        	System.out.println("____excute update ______"+status );
        	if(status==0) {throw new DAOException ("echec de l'insertion");}
        	
        }
        catch (Exception e) { 
        	e.printStackTrace();
        	System.out.println(e.getMessage());
        	throw new DAOException(e);
        } finally {
        	fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
	}

	@Override
	public Livre trouver(Long id) throws  DAOException {
		
	System.out.println("hna raw f trouver lewla"+id);
		return trouver(SQL_SELECT_PAR_ID, id);
	}
	
	

	@Override
	public List<Livre> Afficher() throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Livre> livres= new ArrayList<Livre>();
        Livre livre = null;
        
        try {
        	connexion = daofactory.getConnection();
            System.out.println("recupira dao fel affiichage");
            
            preparedStatement = connexion.prepareStatement(SQL_SELECT_koulach);
            resultSet = preparedStatement.executeQuery();
            System.out.println("_____________Query te3 affichage tous excutee_______________________");
            while(resultSet.next()) {
            	System.out.println();
            	System.out.println("____ "+ resultat(resultSet).getId()+" ___");
            	livres.add(resultat(resultSet));
            	
            }
            
        }
        catch(SQLException e) {
        	System.out.println(e);
        	 throw new DAOException( e );
        }finally{fermeturesSilencieuses( resultSet, preparedStatement, connexion );}
		return livres;
	}
	
	
	
	@Override
	public List<Livre> Chercher( Object...objets) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Livre> livres= new ArrayList<Livre>();
        Livre livre = null;
        
        
        try {
        	connexion = daofactory.getConnection();
        	preparedStatement= initialisationRequetePreparee(connexion, SQL_SELECT_PAR_haja, false, objets);
        	resultSet=preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		System.out.println(resultSet.getMetaData().getColumnName(2));
        		System.out.println("++++++++++++");
        		livres.add(resultat(resultSet));
        		System.out.println(livres.toArray().length);
        	}
        }
        catch(SQLException e) {
        	System.out.println(e);
        	throw new DAOException (e);
        } 
        finally {}
        
        
		return livres;
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
           // connexion.commit();
            System.out.println("excuta query");
            System.out.println(resultSet.toString()+"  ya333 "+ resultSet.findColumn("auteur")+resultSet.next());
            System.out.println(resultSet.getBoolean(1)+"   "+resultSet.getFetchSize() + resultSet.getString(2));

            System.out.println(resultSet.isFirst()+"  ya333 "+ resultSet.isWrapperFor(LivreDAO.class));
            System.out.println(" while");
          //  System.out.println(resultSet.getBoolean(1)+"   "+resultSet.getFetchSize() + resultSet.getString(2));

            /* Parcours de la ligne de données retournée dans le ResultSet */
            while ( resultSet.next() ) {
            	System.out.println("");
                livre = resultat( resultSet );
            }
            System.out.println("");
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
		System.out.println("fel unwrapp" + "    ");
		
		livre.setId(resultset.getLong("id"));
		livre.setAuteur(resultset.getString("auteur"));
		livre.setTitre(resultset.getString("titre"));
		livre.setType(resultset.getString("type"));
		livre.setEdition(resultset.getString("edition"));
		livre.setConsult(resultset.getString("consult"));
		livre.setNbpage(resultset.getInt("nbpage"));
		livre.setPrix(resultset.getFloat("prix"));
		livre.setDate(resultset.getDate("date"));
		livre.setPdf(resultset.getBytes("pdf"));
		
		
		return livre;
	}

}
