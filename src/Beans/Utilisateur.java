package Beans;

public class Utilisateur {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String motdepass;
	private String role;
	public Utilisateur(int id, String nom, String prenom, String email, String motdepass, String role) {
	
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motdepass = motdepass;
		this.role = role;
	}
	public Utilisateur(String nom, String prenom, String email, String motdepass, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motdepass = motdepass;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotdepass() {
		return motdepass;
	}
	public void setMotdepass(String motdepass) {
		this.motdepass = motdepass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
