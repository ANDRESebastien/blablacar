package fr.blablacar.html.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

public class TrajetForm {

	@NotNull
	@Size(min = 1)
	private Long idPersonne;
	private Integer nombrePlace;

	private Date dateDepart;
	private Short heureDepart;
	private Short minuteDepart;

	private String villeDepart;
	private String villeArrive;

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}

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
