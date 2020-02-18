package fr.tse.myapp.domain;

public class UserDTO {
	

		private long idBDD;
		
	
		private String nom;
		
	
		private String prenom;
		
	
		private String email;
		
	
		private String mdp;

		public UserDTO(String nom, String prenom, String email, String mdp) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.mdp = mdp;
		}
		
		public UserDTO(String email, String mdp) {
			super();

			this.email = email;
			this.mdp = mdp;
		}
		
		public UserDTO() {
			super();

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


