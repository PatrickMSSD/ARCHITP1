package service;

import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Utilisateur;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	public long inscription(Utilisateur inscri) {
		
		Utilisateur user = new Utilisateur();
		
		userRepository.save(inscri);
		user = userRepository.getUserConnexion(inscri.getEmail(), inscri.getMdp());
		
		// retourne l'utilisateur pour son ID
		return user.getIdBDD();	
	}
	
	public Utilisateur connexion(Utilisateur connecte) {
		
		Utilisateur user = new Utilisateur();

		user = userRepository.getUserConnexion(connecte.getEmail(), connecte.getMdp());

		return user;
		
	}
	
	
	
	
	
	
	
	
}
