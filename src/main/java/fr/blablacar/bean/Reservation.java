package fr.blablacar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idReservation;

	private int nombrePlaceReserve;

	public long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}

	public int getNombrePlaceReserve() {
		return nombrePlaceReserve;
	}

	public void setNombrePlaceReserve(int nombrePlaceReserve) {
		this.nombrePlaceReserve = nombrePlaceReserve;
	}
}
