package fr.blablacar.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.blablacar.table.Personne;

@RestController("/personne")
public class RestPersonne {

	@GetMapping
	public Personne lister(@RequestParam(value = "id") String idPersonne) {
		Personne personne = new Personne();
		return personne;
	}

	@PutMapping
	public Personne modifier(@RequestParam(value = "nom", defaultValue = "defaultValue") String nom) {
		Personne personne = new Personne();
		return personne;
	}

	@PostMapping
	public Personne ajouter(@RequestParam(value = "nom", defaultValue = "defaultValue") String nom) {
		Personne personne = new Personne();
		return personne;
	}
	
	@DeleteMapping
	public Personne supprimer(@RequestParam(value = "nom", defaultValue = "defaultValue") String nom) {
		Personne personne = new Personne();
		return personne;
	}
}
