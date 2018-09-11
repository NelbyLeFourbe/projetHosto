package sopra.promo404.hopital.model;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

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
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonView(Views.ViewSalle.class)
	private Salle salle;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonView(Views.ViewPatient.class)
	private Patient patient;
	
	
	public Consultation() {
		super();
	}

	public Salle getSalle() {
		return salle;
	}

	public Consultation(Long id, Date dateVisiteArrivee, Date dateVisiteFin, Salle salle, Patient patient) {
		super();
		this.id = id;
		this.dateVisiteArrivee = dateVisiteArrivee;
		this.dateVisiteFin = dateVisiteFin;
		this.salle = salle;
		this.patient = patient;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
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
