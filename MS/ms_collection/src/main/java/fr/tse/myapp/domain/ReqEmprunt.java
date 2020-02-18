package fr.tse.myapp.domain;

public class ReqEmprunt {
	
	private long idLivre;
	private String email;
	private String mdp;
	
	public ReqEmprunt(long idLivre, String email, String mdp) {
		super();
		this.idLivre = idLivre;
		this.email = email;
		this.mdp = mdp;
	}
	
	public ReqEmprunt() {
	}

	public long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(long idLivre) {
		this.idLivre = idLivre;
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
		return "ReqEmprunt [idLivre=" + idLivre + ", email=" + email + ", mdp=" + mdp + "]";
	}
	
	
	

}
