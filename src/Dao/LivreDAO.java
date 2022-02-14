package Dao;

import java.util.List;

import Beans.Livre;

public interface LivreDAO {

	
	void Ajouterlivre( Livre livre ) throws DAOException;

    Livre trouver( Long id ) throws DAOException;
    
    List<Livre> Afficher() throws DAOException;
    
    void supprimer () throws DAOException;
    
    void modifier () throws DAOException;
    
    List<Livre> Chercher () throws DAOException;
}
