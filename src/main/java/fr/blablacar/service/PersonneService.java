package fr.blablacar.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.blablacar.bean.Personne;
import fr.blablacar.repository.PersonneRepository;

@Service
public class PersonneService {

	@Autowired
	PersonneRepository personneRepository;

	public Personne rechercher(long id) {
		Personne personne = this.personneRepository.findOne(id);
		return personne;
	}

	public Personne rechercher(String email, String motDePasse,
			 String nom, String prenom,
			 Date dateDeNaissance) {
		Personne personne = this.personneRepository.findOneByEmailANDNomANDPrenomANDDateDeNaissance(email, nom, prenom, dateDeNaissance);
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

	public void supprimer(long id) {
		this.personneRepository.delete(id);
	}
}
