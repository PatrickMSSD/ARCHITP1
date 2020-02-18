package fr.tse.myapp.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.tse.myapp.domain.Utilisateur;
import fr.tse.myapp.service.UserService;

@RestController
public class UserApi {

	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path = "Inscription", method = RequestMethod.POST, consumes = {"application/json"},produces = {"application/json"})
	public long inscription(@RequestBody Utilisateur inscri) throws IOException {
		long id = this.userService.inscription(inscri); 
		return id;
	}
	
	@RequestMapping(path = "Connexion", method = RequestMethod.POST, consumes = {"application/json"},produces = {"application/json"})
	public Utilisateur connexion(@RequestBody Utilisateur connecte) throws IOException {
		Utilisateur user = this.userService.connexion(connecte); 
		return user;
	}
}
