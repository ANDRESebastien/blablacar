package fr.blablacar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.blablacar.bean.Personne;
import fr.blablacar.bean.Reservation;
import fr.blablacar.bean.Trajet;
import fr.blablacar.repository.PersonneRepository;
import fr.blablacar.repository.ReservationRepository;
import fr.blablacar.repository.TrajetRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	PersonneRepository personneRepository;

	@Autowired
	TrajetRepository trajetRepository;

	public Reservation rechercher(long idTrajet) {
		Reservation reservation = this.reservationRepository.findOne(idTrajet);
		return reservation;
	}

	public Iterable<Reservation> lister() {
		Iterable<Reservation> listeReservation = this.reservationRepository.findAll();
		return listeReservation;
	}

	public Reservation ajouter(long idPassager, int nombrePlaceReserve) {
		Reservation reservation = new Reservation();
		reservation.setNombrePlaceReserve(nombrePlaceReserve);
		Personne passager = personneRepository.findOne(idPassager);
		reservation.setPassager(passager);
		
		
		return this.reservationRepository.save(reservation);
	}

	public void supprimer(long idTrajet) {
		this.reservationRepository.delete(idTrajet);
	}
}