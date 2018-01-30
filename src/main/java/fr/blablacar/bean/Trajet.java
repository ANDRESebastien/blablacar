package fr.blablacar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trajet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTrajet;
	
	@NotBlank
	private int nombrePlace;
	
	@NotBlank
	private String villeDepart;
	
	@NotBlank
	private String villeArrive;
	
	@JsonIgnore
	@ManyToOne
	private Personne conducteur;

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

}
