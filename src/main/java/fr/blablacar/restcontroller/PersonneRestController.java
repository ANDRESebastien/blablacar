package fr.blablacar.restcontroller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.blablacar.bean.Personne;
import fr.blablacar.service.PersonneService;

@RestController
@RequestMapping("/personne")
public class PersonneRestController {

	@Autowired
	private PersonneService personneService;

	@GetMapping("/{id}")
	public Personne rechercher(@PathVariable("id") Long id) {
		return this.personneService.rechercher(id);
	}

	@GetMapping
	public Iterable<Personne> lister() {
		return this.personneService.lister();
	}

	@PostMapping("/{email}/{motDePasse}/{nom}/{prenom}")
	public void ajouter(@PathVariable("email") String email, @PathVariable("motDePasse") String motDePasse,
			@PathVariable("nom") String nom, @PathVariable("prenom") String prenom,
			@PathVariable("dateDeNaissance") Date dateDeNaissance) {
		this.personneService.ajouter(email, motDePasse, nom, prenom, dateDeNaissance);
	}
	
	@PostMapping
	public void ajouter(@RequestBody Personne personne) {
		this.personneService.ajouter(personne);
	}

	@DeleteMapping("{id}")
	public void supprimer(@PathVariable("id") Long id) {
		this.personneService.supprimer(id);
	}
}
