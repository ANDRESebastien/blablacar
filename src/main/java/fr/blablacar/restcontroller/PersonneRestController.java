package fr.blablacar.restcontroller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
@RequestMapping("/api/personne")
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

	@PostMapping("{email}/{motDePasse}/{nom}/{prenom}/{dateDeNaissance}")
	public Personne ajouter(@PathVariable("email") String email, @PathVariable("motDePasse") String motDePasse,
			@PathVariable("nom") String nom, @PathVariable("prenom") String prenom,
			@PathVariable("dateDeNaissance") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dateDeNaissance) {
		
		System.out.println("PersonneRestController:ajouter(email=" + email + ", motDePasse=" + motDePasse + ", nom="
				+ nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance + ")");
		
		return this.personneService.ajouter(nom, email, motDePasse, dateDeNaissance, prenom);
	}

	@PostMapping
	public Personne ajouter(@RequestBody Personne personne) {
		System.out.println("PersonneRestController:ajouter(personne.getNom()=" + personne.getNom()
				+ " personne.getEmail()=" + personne.getEmail() + " personne.getDateDeNaissance()="
				+ personne.getDateDeNaissance() + ")");
		return this.personneService.ajouter(personne);
	}

	@PostMapping("/trajet/{idPersonne}/{nombrePlace}/{villeDepart}/{villeArrive}/{dateDepart}/{heureDepart}")
	public Personne ajouterTrajet(@PathVariable("idPersonne") long idPersonne,
			@PathVariable("nombrePlace") int nombrePlace, @PathVariable("villeDepart") String villeDepart,
			@PathVariable("villeArrive") String villeArrive, @PathVariable("dateDepart") String sDateDepart,
			@PathVariable("heureDepart") String sHeureDepart) {
		System.out.println(
				"PersonneRestController:ajouterTrajet() sDateDepart=" + sDateDepart + " sHeureDepart=" + sHeureDepart);

		LocalDate dateDepart = LocalDate.parse(sDateDepart, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
		LocalTime heureDepart = LocalTime.parse(sHeureDepart, DateTimeFormatter.ofPattern("HH:mm"));

		return this.personneService.ajouterTrajet(idPersonne, nombrePlace, villeDepart, villeArrive, dateDepart,
				heureDepart);
	}

	@PostMapping("/reservation/{idPersonne}/{idTrajet}/{nombrePlaceReserve}")
	public Personne ajouterReservation(@PathVariable("idPersonne") long idPersonne,
			@PathVariable("idTrajet") long idTrajet, @PathVariable("nombrePlaceReserve") int nombrePlaceReserve) {
		return this.personneService.ajouterReservation(idPersonne, idTrajet, nombrePlaceReserve);
	}

	@DeleteMapping("{idPersonne}")
	public void supprimer(@PathVariable("idPersonne") Long idPersonne) {
		this.personneService.supprimer(idPersonne);
	}
}
