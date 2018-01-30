package fr.blablacar.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.blablacar.bean.Trajet;
import fr.blablacar.service.TrajetService;

@RestController
@RequestMapping("/trajet/")
public class TrajetRestController {

	@Autowired
	private TrajetService trajetService;

	@GetMapping("{id}")
	public Trajet rechercher(@PathVariable("id") Long id) {
		return this.trajetService.rechercher(id);
	}

	@GetMapping
	public Iterable<Trajet> lister() {
		return this.trajetService.lister();
	}

	@PostMapping("{nombrePlace}/{villeDepart}/{villeArrive}")
	public Trajet ajouter(@PathVariable("nombrePlace") int nombrePlace, @PathVariable("villeDepart") String villeDepart,
			@PathVariable("villeArrive") String villeArrive) {
		System.out.println("ajouter EL");
		return this.trajetService.ajouter(nombrePlace,villeDepart,villeArrive);
	}
	
	@PostMapping
	public Trajet ajouter(@RequestBody Trajet trajet) {
		System.out.println("ajouter body");
		return this.trajetService.ajouter(trajet);
	}

	@DeleteMapping("{id}")
	public void supprimer(@PathVariable("id") Long id) {
		this.trajetService.supprimer(id);
	}
}
