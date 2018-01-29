package fr.blablacar.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.blablacar.table.Personne;

@RestController("/personne")
public class RestPersonne {
	
	
	
	@GetMapping("/")
	public Personne lister(@RequestParam(value = "id") String idPersonne) {
		
		return personne;
	}
	
	@PutMapping
	public Personne modifier(@RequestParam(value = "nom", defaultValue = "defaultValue") String nom) {
		Personne personne = new Personne();
		
		
		return personne;
	}

}
