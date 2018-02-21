package fr.blablacar.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

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

	private String prenom;

	// @JsonFormat(pattern = "yyyy-MM-dd")
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDeNaissance;

	private double note;
	private boolean active;

	@OneToMany(mappedBy = "conducteur")
	private List<Trajet> listeTrajet;

	@OneToMany(mappedBy = "passager")
	private List<Reservation> listeReservation;

	public Personne() {
		this.note = -1;
		this.active = false;
		// java.util.Date date = (java.util.Date) java.sql.Date.valueOf(localDate);
		// LocalDate localDate = LocalDate.fromDateFields(date);
		// LocalDate localDate = ((java.sql.Date)java.util.Date).toLocalDate();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.dateDeNaissance = dateFormat.parse("1990-01-01");
		} catch (ParseException e) {
			System.out.println("dateDeNaissance KO");
		}
		this.prenom = "toto";
	}

	public String toString() {
		return "idPersonne=" + idPersonne + ";nom=" + nom + ";email=" + email + ";prenom=" + prenom
				+ ";dateDeNaissance=" + dateDeNaissance;
	}

	public long getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public double getNote() {
		return this.note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public boolean isAuthentifie() {
		return this.active;
	}

	public void setAuthentifie(boolean authentifie) {
		this.active = authentifie;
	}

	public List<Trajet> getListeTrajet() {
		return this.listeTrajet;
	}

	public void setListeTrajet(List<Trajet> listeTrajet) {
		this.listeTrajet = listeTrajet;
	}

	public Date getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public List<Reservation> getListeReservation() {
		return this.listeReservation;
	}

	public void setListeReservation(List<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}
}
