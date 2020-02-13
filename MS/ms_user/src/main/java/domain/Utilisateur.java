package domain;

import javax.persistence.*;

@Entity
@Table(name = "Utilisateurs")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idBDD")
	private long idBDD;
	
	@Column(name ="nom")
	private String nom;
	
	@Column(name ="prenom")
	private String prenom;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="mdp")
	private String mdp;

	public Utilisateur(long idBDD, String nom, String prenom, String email, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}
	
	public Utilisateur() {
		
	}
	
	

	public long getIdBDD() {
		return idBDD;
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp + "]";
	}
	
	
	
	
}
