package Dao;

import java.util.List;

import Beans.Livre;

public interface LivreDAO {

	
	void Ajouterlivre( Livre livre ) throws DAOException, Exception;

    Livre trouver( Long id ) throws DAOException;
    
    List<Livre> Afficher() throws DAOException;
    
    void supprimer (Long id) throws DAOException;
    
    
    List<Livre> Chercher ( Object...objets) throws DAOException;

	void modifier(String champ,String valeur, Long id) throws DAOException;
}
