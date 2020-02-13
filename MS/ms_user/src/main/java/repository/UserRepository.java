package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import domain.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur,String> {

	@SuppressWarnings("unchecked")
	public Utilisateur save(Utilisateur user);
	
	@Query(value = "FROM Utilisateurs a WHERE a.email = :email AND a.mdp = :mdp")
	public Utilisateur getUserConnexion(@Param("email") String email,@Param("mdp") String mdp);
	
	@Query(value = "FROM Utilisateurs a WHERE a.idBDD = :idBDD")
	public Utilisateur getUserFromId(@Param("idDoc") String idDoc);
	
}
