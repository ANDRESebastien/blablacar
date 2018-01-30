package fr.blablacar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.blablacar.bean.Trajet;

@Repository
public interface TrajetRepository extends CrudRepository<Trajet, Long> {
}