package fr.blablacar.bean;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trajet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTrajet;

	@JsonIgnore
	@ManyToOne
	private Personne conducteur;

	@NotNull
	private int nombrePlace;

	@NotBlank
	private String villeDepart;

	@NotBlank
	private String villeArrive;

	@NotBlank
	private Date dateDepart;

	@NotBlank
	private Time heureDepart;

	@OneToMany(mappedBy = "trajet")
	private List<Reservation> listeReservation;

	public List<Reservation> getListeReservation() {
		if (this.listeReservation == null) {
			this.listeReservation = new ArrayList<>();
		}
		return listeReservation;
	}

	public void setListeReservation(List<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}

	public String toString() {
		return "idTrajet=" + idTrajet + ";nombrePlace=" + nombrePlace + ";villeDepart=" + villeDepart + ";villeArrive="
				+ villeArrive;
	}

	public Personne getConducteur() {
		return conducteur;
	}

	public void setConducteur(Personne conducteur) {
		this.conducteur = conducteur;
	}

	public long getIdTrajet() {
		return idTrajet;
	}

	public void setIdTrajet(long idTrajet) {
		this.idTrajet = idTrajet;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrive() {
		return villeArrive;
	}

	public void setVilleArrive(String villeArrive) {
		this.villeArrive = villeArrive;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Time getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}
}