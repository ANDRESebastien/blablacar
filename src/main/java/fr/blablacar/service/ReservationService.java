package fr.blablacar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.blablacar.bean.Reservation;
import fr.blablacar.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	public Reservation rechercher(long idTrajet) {
		Reservation reservation = this.reservationRepository.findOne(idTrajet);
		return reservation;
	}

	public Iterable<Reservation> lister() {
		Iterable<Reservation> listeReservation = this.reservationRepository.findAll();
		return listeReservation;
	}

	public void supprimer(long idTrajet) {
		this.reservationRepository.delete(idTrajet);
	}
}