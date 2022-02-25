package Servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
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
import sun.awt.image.ByteArrayImageSource;

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
	
		
	//	livreDao.supprimer((long) 23);
		List<Livre> li= livreDao.Afficher();
		
		String name = null;
		
		try{
		
		//String fileId = (String)request.getParameter("name");
		//String sql = "select f.file from File f where f.fileId="+fileId;
		//préparation de l'instruction SQL
		//resultat = statement.executeQuery(sql);
 
		//récupération de l'image (BLOB)
 
		
		}
			catch(Exception e){
			e.printStackTrace();}
 
		BufferedInputStream bis =null;
		BufferedOutputStream bos = null;
		OutputStream out =new OutputStream() {
			
			@Override
			public void write(int b) throws IOException {
				
				
			}
		};
 /*
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=monFichier.pdf");
		response.setContentLength(10000);*/
 
		try{
			
			
			//InputStream streamDuBlob = myblob.getBinaryStream();
 
			//bis = new BufferedInputStream(streamDuBlob);
			bos = new BufferedOutputStream(out);
		}
		catch(Exception e){
			e.printStackTrace();
		}
 
		byte[] input = li.get(7).getPdf();
		boolean eof = false;
		System.out.println(input.length);
			bos.write(input, 0, input.length);
			
		System.out.println();
		bos.flush();
		ByteArrayDataSource bads=new ByteArrayDataSource(input, "application/pdf");
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		ByteArrayInputStream bin= new ByteArrayInputStream(input);
		
		InputStreamReader ir=new InputStreamReader(bads.getInputStream(),"UTF-8");
		
		
		System.out.println(input+" "+bads.getContentType());
		//bout.write(input);
		System.out.println(ir.read());
		int ligneFile = 0;
		int nmLigne=0;
	    BufferedReader br= new BufferedReader(ir);
	   
	    String laLigne;
while ((laLigne = br.readLine()) != null){
	
	//System.out.println();
}
	    //System.out.println(br.readLine());
        
        br.close();
		String s=new String(bout.toString());
		
		
		//OutputStream outs= new BufferedOutputStream(bads.getOutputStream());
		
	/*	
		response.setContentType("text/html");
		PrintWriter print=response.getWriter();
		String FileName="monFichier.pdf";
		String Filepath= "C:\\Users\\DELL\\Downloads\\";
		response.setContentType("APPLICATION/PDF");
		response.setHeader("Content-Disposition", "inline; fileName=\""+FileName+"\"");
		FileInputStream fi=new FileInputStream(Filepath+FileName);
		int i ;
		while ((i=fi.read()) != -1) 
			print.write(i);
			fi.close();
			print.close();
		*/
		//response.setContentLength();
		
		request.setAttribute("livre", li);
		request.setAttribute("bos", "");
		//response.setCharacterEncoding("UTF-8");
		System.out.println("encoding");
		//OutputStream outs = response.getOutputStream();
		String string=Base64.getEncoder().encodeToString(input);
		
		//String stri=Base64.getEncoder().encodeToString()
		System.out.println("ouputstream");
		//outs.write(input);
		System.out.println("yaaaa");
		
		
		File dir= new File("C:\\Users\\DELL\\workspaceJEE\\Biblio");
		//System.out.println(this.getServletContext().get);
		File fichier=File.createTempFile("fichiername", ".pdf", dir);
		
		//Path file=Files.createTempFile(fichier.toPath(),"fichierrname",".pdf");
		
		System.out.println(dir.getAbsolutePath());
		System.out.println(fichier.getAbsolutePath());
		
		Files.write(fichier.toPath(), input);
		
		System.out.println(fichier.toURI());
		System.out.println(fichier.toURL());
		
		String ss=fichier.getName();
		System.out.println(ss);
	/*
	List<Livre> listes=livreDao.Chercher("");
	for (int i=0; i<listes.size();i++)
	System.out.println(listes.get(i).getDate());*/
		request.setAttribute("base", bads);
		request.setAttribute("fi",ss);
		System.out.println(ss);
		//outs.write(li.get(8).getPdf());
		//System.out.println(outs.toString()+"   ");
		//ByteArrayDataSource bt =new ByteArrayDataSource(li.get(8).getPdf(), "application/pdf");
		
		//System.out.println("________"+li.get(2).getPdf());
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/wassiimkhra.jsp" ).forward( request, response );
	}

	
}
