package Servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.util.ByteArrayDataSource;

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
	
		List<Livre> li= livreDao.Afficher();
		System.out.println();
		request.setAttribute("livre", li);
		OutputStream outs = response.getOutputStream();
		outs.write(li.get(8).getPdf());
		System.out.println(outs.toString()+"   ");
		//ByteArrayDataSource bt =new ByteArrayDataSource(li.get(8).getPdf(), "application/pdf");
		
		System.out.println("________"+li.get(8).getPdf());
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/wassiimkhra.jsp" ).forward( request, response );
	}

	
}
