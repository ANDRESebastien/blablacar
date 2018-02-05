package fr.blablacar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.blablacar.bean.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}