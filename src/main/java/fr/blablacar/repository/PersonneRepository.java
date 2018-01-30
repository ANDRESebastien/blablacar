package fr.blablacar.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.blablacar.bean.Personne;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, Long> {
	 public Personne findOneByEmailANDNomANDPrenomANDDateDeNaissance(String email, String Nom, String Prenom, Date DateDeNaissance);

}
