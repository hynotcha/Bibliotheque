package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Livre;
import Dao.DAOFactory;
import Dao.LivreDAO;

/**
 * Servlet implementation class Afficher
 */
@WebServlet("/Afficher")
public class Afficher extends HttpServlet {
	private static final long serialVersionUID = 1L;
private LivreDAO livreDao;
    
    public void init() throws ServletException{
    	this.livreDao= ((DAOFactory)getServletContext().getAttribute("daofactory")).getLivreDao();}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Livre li=
		livreDao.trouver( (long) 1);
		System.out.println("________");
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/wassiimkhra.jsp" ).forward( request, response );
	}

	
}
