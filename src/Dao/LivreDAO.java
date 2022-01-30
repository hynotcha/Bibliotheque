package Dao;

import Beans.Livre;

public interface LivreDAO {

	
	void Ajouterlivre( Livre livre ) throws DAOException;

    Livre trouver( Long id ) throws DAOException;
}
