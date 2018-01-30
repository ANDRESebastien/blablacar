package fr.blablacar.bean;

import java.sql.Timestamp;

public class Reservation {
	private long idReservation;
	private Personne passager;
	private Trajet trajet;
	private int nombrePlaceReserve;
	private Timestamp timestampReservation;

	public long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}

	public Personne getPassager() {
		return passager;
	}

	public void setPassager(Personne passager) {
		this.passager = passager;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public int getNombrePlaceReserve() {
		return nombrePlaceReserve;
	}

	public void setNombrePlaceReserve(int nombrePlaceReserve) {
		this.nombrePlaceReserve = nombrePlaceReserve;
	}

	public Timestamp getTimestampReservation() {
		return timestampReservation;
	}

	public void setTimestampReservation(Timestamp timestampReservation) {
		this.timestampReservation = timestampReservation;
	}

}
