package Beans;

import java.io.File;
import java.sql.Blob;
import java.sql.Date;





public class Livre {
	private Long id;
	private String titre ;
	private String auteur ;
	private Date date ;
	private  int nbpage ;
	private  float prix;
	private  String type;
	private  String edition;
	private String  consult;
	private byte[] couverture ;
	private byte[] pdf ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNbpage() {
		return nbpage;
	}
	public void setNbpage(int nbpage) {
		this.nbpage = nbpage;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getConsult() {
		return consult;
	}
	public void setConsult(String consult) {
		this.consult = consult;
	}
	public byte[] getCouverture() {
		return couverture;
	}
	public void setCouverture(byte[] couverture) {
		this.couverture = couverture;
	}
	public byte[] getPdf() {
		return pdf;
	}
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", date=" + date + ", nbpage=" + nbpage
				+ ", prix=" + prix + ", type=" + type + ", edition=" + edition + ", consult=" + consult
				+ ", couverture=" + couverture + ", pdf=" + pdf + "]";
	}

	
	
	
	
}
