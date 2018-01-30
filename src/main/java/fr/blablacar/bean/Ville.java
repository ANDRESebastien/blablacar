package fr.blablacar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ville {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idVille;
	private String nom;
	private String codePostal;

	public long getIdVille() {
		return idVille;
	}

	public void setIdVille(long idVille) {
		this.idVille = idVille;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

}
