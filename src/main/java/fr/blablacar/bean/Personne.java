package fr.blablacar.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

//import lombok.Data;
//@Data

@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPersonne;

	@NotBlank
	private String email;

	@NotBlank
	private String motDePasse;

	@NotBlank
	private String nom;

	@NotBlank
	private String prenom;

	@NotBlank
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;

	private double note;
	private boolean authentifie;

	public Personne() {
		this.note = -1;
		this.authentifie = false;
	}

	public long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public boolean isAuthentifie() {
		return authentifie;
	}

	public void setAuthentifie(boolean authentifie) {
		this.authentifie = authentifie;
	}
	
	
}
