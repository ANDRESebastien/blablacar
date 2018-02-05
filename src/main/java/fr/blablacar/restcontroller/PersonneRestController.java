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

	@GetMapping("{idPersonne}")
	public Personne rechercher(@PathVariable("idPersonne") Long idPersonne) {
		return this.personneService.rechercher(idPersonne);
	}

	@GetMapping
	public Iterable<Personne> lister() {
		return this.personneService.lister();
	}

	@PostMapping("{email}/{motDePasse}/{nom}/{prenom}")
	public Personne ajouter(@PathVariable("email") String email, @PathVariable("motDePasse") String motDePasse,
			@PathVariable("nom") String nom, @PathVariable("prenom") String prenom,
			@PathVariable("dateDeNaissance") Date dateDeNaissance) {
		System.out.println("PersonneRestController:ajouter(email=" + email + ", motDePasse=" + motDePasse + ", nom=" + nom+ ", prenom=" + prenom+ ", dateDeNaissance=" + dateDeNaissance + ")");
		return this.personneService.ajouter(email, motDePasse, nom, prenom, dateDeNaissance);
	}

	@PostMapping
	public Personne ajouter(@RequestBody Personne personne) {
		System.out.println("PersonneRestController:ajouter(personne.getNom()=" + personne.getNom() + " personne.getEmail()=" + personne.getEmail() + ")");
		return this.personneService.ajouter(personne);
	}

	@PostMapping("trajet/{idPersonne}/{idTrajet}")
	public Personne ajouterTrajet(@PathVariable("idPersonne") long idPersonne,
			@PathVariable("idTrajet") long idTrajet) {
		System.out.println("PersonneRestController:ajouterTrajet(idPersonne=" + idPersonne + ", idTrajet=" + idTrajet + ")");
		return this.personneService.ajouterTrajet(idPersonne, idTrajet);
	}
	
	@PostMapping("reservation/{idPersonne}/{idReservation}")
	public Personne ajouterReservation(@PathVariable("idPersonne") long idPersonne,
			@PathVariable("idReservation") long idReservation) {
		System.out.println("PersonneRestController:ajouterTrajet(idPersonne=" + idPersonne + ", idTrajet=" + idReservation + ")");
		return this.personneService.ajouterReservation(idPersonne, idReservation);
	}

	@DeleteMapping("{idPersonne}")
	public void supprimer(@PathVariable("idPersonne") Long idPersonne) {
		this.personneService.supprimer(idPersonne);
	}
}
