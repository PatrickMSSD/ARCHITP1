package fr.tse.myapp.domain;

import javax.persistence.*;;

@Entity
@Table(name = "Collections")
public class Collection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBDD")
	private long idBDD;
	
	@Column(name = "idLivre")
	private long idLivre;
	
	@Column(name = "idUser")
	private long idUser;
	
	@Column(name = "dateRetour")
	private String dateRetour;

	

	public Collection(long idLivre, long idUser, String dateRetour) {
		super();
		this.idLivre = idLivre;
		this.idUser = idUser;
		this.dateRetour = dateRetour;
	}

	public Collection() {
		
	}

	
	
	public long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(long idLivre) {
		this.idLivre = idLivre;
	}

	public long getIdBDD() {
		return idBDD;
	}

	public void setIdBDD(long idBDD) {
		this.idBDD = idBDD;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}

	@Override
	public String toString() {
		return "Collection [idBDD=" + idBDD + ", idLivre=" + idLivre + ", idUser=" + idUser + ", dateRetour="
				+ dateRetour + "]";
	}

	

}
