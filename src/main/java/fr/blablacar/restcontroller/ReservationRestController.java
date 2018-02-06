package fr.blablacar.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.blablacar.bean.Reservation;
import fr.blablacar.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;

	@GetMapping("{idReservation}")
	public Reservation rechercher(@PathVariable("idReservation") Long idReservation) {
		return this.reservationService.rechercher(idReservation);
	}

	@GetMapping
	public Iterable<Reservation> lister() {
		return this.reservationService.lister();
	}

	/*
	@PostMapping("{idPassager}/{nombrePlaceReserve}")
	public Reservation ajouter(@PathVariable("idPassager") long idPassager,
			@PathVariable("nombrePlaceReserve") int nombrePlaceReserve) {
		return this.reservationService.ajouter(idPassager, nombrePlaceReserve);
	}
	

	@DeleteMapping("{idReservation}")
	public void supprimer(@PathVariable("idReservation") Long idReservation) {
		this.reservationService.supprimer(idReservation);
	}
	*/
}
