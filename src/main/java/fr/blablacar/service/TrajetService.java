package fr.blablacar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.blablacar.bean.Trajet;
import fr.blablacar.repository.TrajetRepository;

@Service
public class TrajetService {

	@Autowired
	TrajetRepository trajetRepository;

	public Trajet rechercher(long id) {
		Trajet trajet = this.trajetRepository.findOne(id);
		return trajet;
	}

	public Iterable<Trajet> lister() {
		Iterable<Trajet> listeTrajet = this.trajetRepository.findAll();
		return listeTrajet;
	}

	public Trajet ajouter(Trajet trajet) {
		return this.trajetRepository.save(trajet);
	}

	public Trajet ajouter(int nombrePlace, String villeDepart, String villeArrive) {
		Trajet trajet = new Trajet();
		trajet.setNombrePlace(nombrePlace);
		trajet.setVilleDepart(villeDepart);
		trajet.setVilleArrive(villeArrive);
		return this.trajetRepository.save(trajet);
	}

	public void supprimer(long id) {
		this.trajetRepository.delete(id);
	}
}