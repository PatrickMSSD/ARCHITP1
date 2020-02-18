package fr.tse.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.tse.myapp.domain.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection,String> {
	
	// Emprunter
	
	@SuppressWarnings("unchecked")
	public Collection save(Collection col);
	
	// Rendre ? 
	
	public void deleteByidBDD(long idLivre);
	
	
	
	@Query(nativeQuery=true,value = "SELECT * FROM Collections a WHERE a.id_user = :id_user")
	public List<Collection> getUserCollection(@Param("id_user") long idUser);
	
	
	
}
