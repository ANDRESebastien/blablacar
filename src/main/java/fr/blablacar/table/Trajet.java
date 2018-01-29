package fr.blablacar.table;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Trajet {
	private long idTrajet;
	private Personne conducteur;
	private Date jourDepart;
	private Time heureDepart;
	private List<Ville> listeVille;
	private List<Time> heureArrive;
	private int nombrePlace;
	private List<Reservation> listeReservation;
	private List<String> listeOption;

	public long getIdTrajet() {
		return idTrajet;
	}

	public void setIdTrajet(long idTrajet) {
		this.idTrajet = idTrajet;
	}

	public Personne getConducteur() {
		return conducteur;
	}

	public void setConducteur(Personne conducteur) {
		this.conducteur = conducteur;
	}

	public Date getJourDepart() {
		return jourDepart;
	}

	public void setJourDepart(Date jourDepart) {
		this.jourDepart = jourDepart;
	}

	public Time getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}

	public List<Ville> getListeVille() {
		return listeVille;
	}

	public void setListeVille(List<Ville> listeVille) {
		this.listeVille = listeVille;
	}

	public List<Time> getHeureArrive() {
		return heureArrive;
	}

	public void setHeureArrive(List<Time> heureArrive) {
		this.heureArrive = heureArrive;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public List<Reservation> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(List<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}

	public List<String> getListeOption() {
		return listeOption;
	}

	public void setListeOption(List<String> listeOption) {
		this.listeOption = listeOption;
	}

}
