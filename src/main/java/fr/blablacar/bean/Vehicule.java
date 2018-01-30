package fr.blablacar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idVehicule;
	private String marque;
	private String model;

	public long getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(long idVehicule) {
		this.idVehicule = idVehicule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
