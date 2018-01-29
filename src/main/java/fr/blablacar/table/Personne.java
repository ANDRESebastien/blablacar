package fr.blablacar.table;

import java.sql.Date;

public class Personne {
	private long idPersonne;
	private String motDePasse;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String email;
	private double note;
	private boolean authentifie;

	public long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
