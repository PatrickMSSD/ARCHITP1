package fr.tse.myapp.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.tse.myapp.domain.ReqEmprunt;
import fr.tse.myapp.domain.UserDTO;
import fr.tse.myapp.service.CollectionService;

@RestController
public class CollectionApi {

	@Autowired
	CollectionService collectionService;
	
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path = "Emprunter", method = RequestMethod.POST, consumes = {"application/json"},produces = {"application/json"})
	public String emprunter(@RequestBody ReqEmprunt req) throws IOException {
		this.collectionService.emprunterUnLivre(req.getIdLivre(), req.getEmail(), req.getMdp());
		return("Livre emprunter");
	}
	
	@RequestMapping(path = "Rendre", method = RequestMethod.POST, consumes = {"application/json"},produces = {"application/json"})
	public String rendre(@RequestBody ReqEmprunt req) throws IOException {
		this.collectionService.rendreUnLivre(req.getIdLivre());
		return("Livre rendu");
	}
	
	@RequestMapping(path = "Consulter", method = RequestMethod.POST, consumes = {"application/json"},produces = {"application/json"})
	public String consulter(@RequestBody UserDTO user) throws IOException {
		
		return this.collectionService.getCollection(user.getEmail(), user.getMdp());
	}
	
	
	
	
	
}
