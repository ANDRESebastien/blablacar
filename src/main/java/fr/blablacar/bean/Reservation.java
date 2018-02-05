package fr.blablacar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idReservation;

	@JsonIgnore
	@ManyToOne
	private Personne passager;

	@JsonIgnore
	@ManyToOne
	private Trajet trajet;

	private int nombrePlaceReserve;

	public String toString() {
		return "idReservation=" + idReservation + ";nombrePlaceReserve=" + nombrePlaceReserve;
	}

	public long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}

	public Personne getPassager() {
		if (this.passager == null) {
			this.passager = new Personne();
		}
		return passager;
	}

	public void setPassager(Personne passager) {
		this.passager = passager;
	}

	public Trajet getTrajet() {
		if (this.trajet == null) {
			this.trajet = new Trajet();
		}
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

}
