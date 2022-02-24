package Tools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Blob;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class TraitementForms {
	
	
	
	
	public String Champformulaire(HttpServletRequest request, String champ) {
		String ch=request.getParameter(champ);
		if(ch==null|| ch.equals("")) return null;
		
		else return ch;
	}
//------------------------------------------------------------------------------	
	public Date dateformulaire(HttpServletRequest request, String champ) {
		Date date=null;
		System.out.println();
	
		date=Date.valueOf(request.getParameter(champ));
		System.out.println();
		//date= new SimpleDateFormat("dd/mm/yy").parse(Champformulaire(request,champ));
		System.out.println();
	
		return date;
	}
//------------------------------------------------------------------------------
	public byte[] byteform(HttpServletRequest request , String champ) throws IOException, ServletException {
		
		
		InputStream contenu=null;
		try {
			Part part=request.getPart(champ);
			contenu=part.getInputStream();
			
			}
			catch (IllegalStateException e){
				System.out.println(e.getMessage()+"  hihiihii");
			}
		byte[] byt=new byte[contenu.available()];
		contenu.read(byt);
		
		return byt;
	}
//------------------------------------------------------------------------------	
//------------------------------------------------------------------------------	
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
	
	
	
}
