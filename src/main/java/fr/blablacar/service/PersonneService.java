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

	public Personne ajouter(String nom ,String login, String password) {
		Personne personne = new Personne();
		personne.setNom(nom);
		personne.setEmail(login);
		personne.setMotDePasse(password);
		return this.ajouter(personne);
	}

	public Personne ajouter(String email, String motDePasse, String nom, String prenom, Date dateDeNaissance) {
		Personne personne = new Personne();
		personne.setEmail(email);
		personne.setMotDePasse(motDePasse);
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setDateDeNaissance(dateDeNaissance);
		return this.ajouter(personne);
	}

	public Personne ajouter(Personne personne) {
		if (this.personneRepository.findByEmail(personne.getEmail()) == null) {
			return this.personneRepository.save(personne);
		}
		return null;
	}

	public void supprimer(long idPersonne) {
		this.personneRepository.delete(idPersonne);
	}

	@Transactional
	public Personne ajouterTrajet(long idPersonne, int nombrePlace, String villeDepart, String villeArrive) {
		Personne personne = this.rechercher(idPersonne);
		if (personne != null) {
			Trajet trajet = new Trajet();
			trajet.setConducteur(personne);
			trajet.setNombrePlace(nombrePlace);
			trajet.setVilleDepart(villeDepart);
			trajet.setVilleArrive(villeArrive);
			this.trajetRepository.save(trajet);
			return personne;
		} else {
			return null;
		}
	}

	@Transactional
	public Personne ajouterReservation(long idPersonne, long idTrajet, int nombrePlaceReserve) {
		Personne personne = this.personneRepository.findOne(idPersonne);
		Trajet trajet = this.trajetRepository.findOne(idTrajet);

		if (personne != null && trajet != null) {

			if (trajet.getConducteur().getIdPersonne() != idPersonne) {
				Reservation reservation = new Reservation();
				reservation.setPassager(personne);
				reservation.setNombrePlaceReserve(nombrePlaceReserve);
				reservation.setTrajet(trajet);
				this.reservationRepository.save(reservation);
				return personne;
			}
		} else {
			personne = null;
		}
		return personne;
	}

}