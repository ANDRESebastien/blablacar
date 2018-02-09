package fr.blablacar.html.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TrajetForm {
	
	private Integer nombrePlace;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDepart;
	private Short heureDepart;
	private Short minuteDepart;

	private String villeDepart;
	private String villeArrive;

	public Integer getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(Integer nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Short getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Short heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Short getMinuteDepart() {
		return minuteDepart;
	}

	public void setMinuteDepart(Short minuteDepart) {
		this.minuteDepart = minuteDepart;
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