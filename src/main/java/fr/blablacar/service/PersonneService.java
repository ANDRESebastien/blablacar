package fr.blablacar.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.blablacar.bean.Personne;
import fr.blablacar.bean.Reservation;
import fr.blablacar.bean.Trajet;
import fr.blablacar.repository.PersonneRepository;
import fr.blablacar.repository.ReservationRepository;
import fr.blablacar.repository.TrajetRepository;

@Service
public class PersonneService {

	@Autowired
	PersonneRepository personneRepository;

	@Autowired
	TrajetRepository trajetRepository;

	@Autowired
	ReservationRepository reservationRepository;

	public Personne rechercher(long idPersonne) {
		Personne personne = this.personneRepository.findOne(idPersonne);
		return personne;
	}

	public Iterable<Personne> lister() {
		Iterable<Personne> listePersonne = this.personneRepository.findAll();
		return listePersonne;
	}

	public Personne ajouter(Personne personne) {
		return this.personneRepository.save(personne);
	}

	public Personne ajouter(String email, String motDePasse, String nom, String prenom, Date dateDeNaissance) {
		Personne personne = new Personne();
		personne.setEmail(email);
		personne.setMotDePasse(motDePasse);
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setDateDeNaissance(dateDeNaissance);
		return this.personneRepository.save(personne);
	}

	public void supprimer(long idPersonne) {
		this.personneRepository.delete(idPersonne);
	}

	@Transactional
	public Personne ajouterTrajet(long idPersonne, long idTrajet) {
		Personne personne = this.rechercher(idPersonne);
		Trajet trajet = this.trajetRepository.findOne(idTrajet);

		if (personne != null && trajet != null) {
			trajet.setConducteur(personne);
			this.trajetRepository.save(trajet);
			return personne;
		} else {
			return null;
		}
	}

	@Transactional
	public Personne ajouterReservation(long idPersonne, long idReservation) {
		System.out.println("PersonneService:ajouterReservation( idPersonne=" + idPersonne + ", idReservation="
				+ idReservation + ")");
		Personne personne = this.personneRepository.findOne(idPersonne);
		Reservation reservation = this.reservationRepository.findOne(idReservation);
		if (personne != null && reservation != null) {
			System.out
					.println("reservation.getPassager().getIdPersonne()=" + reservation.getPassager().getIdPersonne());

			if (reservation.getTrajet().getConducteur().getIdPersonne() != idPersonne) {
				System.out.println("PersonneService:ajouterReservation(): personne différent");

				reservation.setPassager(personne);
				this.reservationRepository.save(reservation);
				return personne;
			}
		} else {
			personne = null;
		}
		return personne;
	}
}