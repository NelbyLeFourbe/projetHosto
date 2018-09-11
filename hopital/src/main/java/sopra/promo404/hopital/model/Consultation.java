package sopra.promo404.hopital.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Consultation {

	@GeneratedValue
	@Id
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(Views.ViewCommon.class)
	private Date dateVisiteArrivee;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(Views.ViewCommon.class)
	private Date dateVisiteFin;
	@ManyToOne
	@JsonView(Views.ViewSalle.class)
	private Salle salle;
	@ManyToOne
	@JsonView(Views.ViewPatient.class)
	private Patient patient;
	@ManyToOne
	@JsonView(Views.ViewSpecialite.class)
	private Specialite specialite;
	
	
	public Consultation() {
		super();
	}

	public Salle getSalle() {
		return salle;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Consultation(Long id, Date dateVisiteArrivee, Date dateVisiteFin, Salle salle, Patient patient,
			Specialite specialite) {
		super();
		this.id = id;
		this.dateVisiteArrivee = dateVisiteArrivee;
		this.dateVisiteFin = dateVisiteFin;
		this.salle = salle;
		this.patient = patient;
		this.specialite = specialite;
	}

	public Date getDateVisiteArrivee() {
		return dateVisiteArrivee;
	}

	public void setDateVisiteArrivee(Date dateVisiteArrivee) {
		this.dateVisiteArrivee = dateVisiteArrivee;
	}

	public Date getDateVisiteFin() {
		return dateVisiteFin;
	}

	public void setDateVisiteFin(Date dateVisiteFin) {
		this.dateVisiteFin = dateVisiteFin;
	}


public Patient getPatient() {
	return patient;
}

public void setPatient(Patient patient) {
	this.patient = patient;
}
}
