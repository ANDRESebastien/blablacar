package fr.blablacar.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	public Personne rechercher(String nomPersonne) {
		Personne personne = this.personneRepository.findByEmail(nomPersonne);
		return personne;
	}

	public Iterable<Personne> lister() {
		Iterable<Personne> listePersonne = this.personneRepository.findAll();
		return listePersonne;
	}

	public Personne ajouter(String nom, String email, String motDePasse) {
		Personne personne = new Personne();
		personne.setNom(nom);
		personne.setEmail(email);
		personne.setMotDePasse(motDePasse);
		return this.ajouter(personne);
	}

	public Personne ajouter(String nom, String email, String motDePasse, LocalDate dateDeNaissance, String prenom) {
		Personne personne = new Personne();
		personne.setNom(nom);
		personne.setEmail(email);
		personne.setMotDePasse(motDePasse);

		// personne.setDateDeNaissance(DateConversion.conversionDate(dateDeNaissance));
		Date dateNaissance = java.sql.Date.valueOf(dateDeNaissance);
		personne.setDateDeNaissance(dateNaissance);

		personne.setPrenom(prenom);
		System.out.println("PersonneService:ajouter(" + personne.getNom() + ", " + personne.getEmail() + ", "
				+ personne.getMotDePasse() + ", " + personne.getDateDeNaissance() + ", " + personne.getPrenom() + ")");
		return this.ajouter(personne);
	}

	public Personne ajouter(Personne personne) {
		if (this.rechercher(personne.getEmail()) == null) {
//			StandardPasswordEncoder encodeur = new StandardPasswordEncoder("secret");
//			String motDePasseEncode = encodeur.encode(personne.getMotDePasse());
//			personne.setMotDePasse(motDePasseEncode);
			BCryptPasswordEncoder encodeur = new BCryptPasswordEncoder();
			String motDePasseEncode = encodeur.encode(personne.getMotDePasse());
			personne.setMotDePasse(motDePasseEncode);
			
			 
			return this.personneRepository.save(personne);
		}
		return null;
	}

	public void supprimer(long idPersonne) {
		this.personneRepository.delete(idPersonne);
	}

	@Transactional
	public Personne ajouterTrajet(long idPersonne, int nombrePlace, String villeDepart, String villeArrive,
			LocalDate dateDepartLD, LocalTime heureDepartLT) {
		Personne personne = this.rechercher(idPersonne);
		if (personne != null) {
			Trajet trajet = new Trajet();
			trajet.setConducteur(personne);
			trajet.setNombrePlace(nombrePlace);
			trajet.setVilleDepart(villeDepart);
			trajet.setVilleArrive(villeArrive);

			Date dateDepart = (Date) java.sql.Date.valueOf(dateDepartLD);
			Time heureDepart = null;
			// Time heureDepart = new Time(heureDepartLT.toNanoOfDay());

			trajet.setDateDepart(dateDepart);
			trajet.setHeureDepart(heureDepart);

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