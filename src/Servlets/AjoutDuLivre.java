package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Livre;
import Dao.DAOFactory;
import Dao.LivreDAO;
import forms.TraiterFormLivre;

@MultipartConfig
@WebServlet("/AjoutDuLivre")
public class AjoutDuLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LivreDAO livreDao;
    
    public void init() throws ServletException{
   
    	this.livreDao= ((DAOFactory)getServletContext().getAttribute("daofactory")).getLivreDao();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Livre.jsp" ).forward( request, response );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		TraiterFormLivre traitement=new TraiterFormLivre(livreDao);
		Livre livre = null;
		try {
			livre = traitement.ajouterlivre(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("livre", livre);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/wassiimkhra.jsp" ).forward( request, response );
	}

	
}
