package forms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import Beans.Livre;
import Dao.LivreDAO;
import Tools.TraitementForms;

public class TraiterFormLivre {
	private static final String titre  = "titre";
    private static final String auteur = "auteur";
    private static final String date="datesortie";
    private static final String nbpage="nombrepage";
    private static final String prix="prix";
    private static final String type="type";
    private static final String edition="edition";
    private static final String consultation="consult";
    private TraitementForms tf=new TraitementForms();
    private LivreDAO livreDao;
    
    
    public TraiterFormLivre (LivreDAO livreDao) {
    	this.livreDao=livreDao;
    }
    
    
    
    public Livre ajouterlivre(HttpServletRequest request) {
		
    	String titre1=tf.Champformulaire(request, titre);
    	String auteur1=tf.Champformulaire(request, auteur);
    	Date date1=tf.dateformulaire(request, date);
    	int nbpage1=Integer.parseInt(tf.Champformulaire(request, nbpage));
    	float prix1=Float.parseFloat(tf.Champformulaire(request, prix));
    	String  type1=tf.Champformulaire(request, type);
    	String edition1=tf.Champformulaire(request, edition);
    	String consult1=tf.Champformulaire(request, consultation);

    	
    	
    	Livre livre=new Livre();
    	livre.setTitre(titre1);
    	livre.setAuteur(auteur1);
    	livre.setDate(date1);
    	livre.setNbpage(nbpage1);
    	livre.setPrix(prix1);
    	livre.setType(type1);
    	livre.setEdition(edition1);
    	livre.setConsult(consult1);
    	
    	livreDao.Ajouterlivre(livre);
    	  	
    	return livre;
    }
   
}
