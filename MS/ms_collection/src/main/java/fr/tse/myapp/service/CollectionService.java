package fr.tse.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.tse.myapp.domain.Collection;
import fr.tse.myapp.domain.UserDTO;
import fr.tse.myapp.repository.CollectionRepository;

@Service
public class CollectionService {

	@Autowired
	CollectionRepository collectionRepository;

	public void emprunterUnLivre(long idLivre, String email, String mdp) {

		RestTemplate restTemplate = new RestTemplate();

		UserDTO userReq = new UserDTO(email, mdp);
		UserDTO userRep = new UserDTO();

		userRep = restTemplate.postForObject("http://localhost:8082/Connexion", userReq, UserDTO.class);

		Collection maCol = new Collection(idLivre, userRep.getIdBDD(), "oui");
		collectionRepository.save(maCol);

	}

	public void rendreUnLivre(long idLivre) {
		

		collectionRepository.deleteByidBDD(idLivre);
		
	}

	public String getCollection(String email, String mdp) {
		List<Collection> maCollection = new ArrayList<Collection>();
		
		RestTemplate restTemplate = new RestTemplate();

		UserDTO userReq = new UserDTO(email, mdp);
		UserDTO userRep = new UserDTO();

		userRep = restTemplate.postForObject("http://localhost:8082/Connexion", userReq, UserDTO.class);

		maCollection = collectionRepository.getUserCollection(userRep.getIdBDD());
		
		return maCollection.toString();
		
	}
	
	
	
}
