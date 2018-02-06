package fr.blablacar.repository;

import fr.blablacar.bean.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, Long> {
	Personne findByEmail(String email);
}