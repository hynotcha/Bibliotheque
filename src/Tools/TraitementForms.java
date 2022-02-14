package Tools;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TraitementForms {
	
	
	
	
	public String Champformulaire(HttpServletRequest request, String champ) {
		String ch=request.getParameter(champ);
		if(ch==null|| ch.equals("")) return null;
		
		else return ch;
	}
//------------------------------------------------------------------------------	
	public Date dateformulaire(HttpServletRequest request, String champ) {
		Date date=null;
		try {
			System.out.println("---"+champ);
			 date=new SimpleDateFormat("dd/mm/yy").parse(Champformulaire(request,champ));
			System.out.println(date+"   hiihihi      "+date+"------");
		    }
		catch (ParseException e) {
			
			e.printStackTrace();
		}
	
		return date;
	}
//------------------------------------------------------------------------------
	public File couvertureform(HttpServletRequest request) {
		
		return null;
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
