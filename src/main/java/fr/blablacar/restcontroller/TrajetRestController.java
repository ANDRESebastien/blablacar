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
@RequestMapping("/trajet")
public class TrajetRestController {

	@Autowired
	private TrajetService trajetService;

	@GetMapping("{idTrajet}")
	public Trajet rechercher(@PathVariable("idTrajet") Long idTrajet) {
		return this.trajetService.rechercher(idTrajet);
	}

	@GetMapping
	public Iterable<Trajet> lister() {
		return this.trajetService.lister();
	}

	@PostMapping("{nombrePlace}/{villeDepart}/{villeArrive}")
	public Trajet ajouter(@PathVariable("nombrePlace") int nombrePlace, @PathVariable("villeDepart") String villeDepart,
			@PathVariable("villeArrive") String villeArrive) {
		System.out.println("TrajetRestController:ajouter( nombrePlace=" + nombrePlace + ", villeDepart=" + villeDepart
				+ ", villeArrive=" + villeArrive);
		return this.trajetService.ajouter(nombrePlace, villeDepart, villeArrive);
	}

	@PostMapping
	public Trajet ajouter(@RequestBody Trajet trajet) {
		System.out.println("TrajetRestController:ajouter( trajet.getNombrePlace()=" + trajet.getNombrePlace()
				+ ", trajet.getVilleDepart()=" + trajet.getVilleDepart() + ", trajet.getVilleArrive()="
				+ trajet.getVilleArrive() + ")");
		return this.trajetService.ajouter(trajet);
	}

	@DeleteMapping("{idTrajet}")
	public void supprimer(@PathVariable("idTrajet") Long idTrajet) {
		this.trajetService.supprimer(idTrajet);
	}
}
