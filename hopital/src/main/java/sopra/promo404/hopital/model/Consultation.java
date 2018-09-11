package sopra.promo404.hopital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class Consultation {
	
	@GeneratedValue
	@Id
	private Long id; 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateVisiteArrivee; 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateVisiteFin;
	
	
	public Consultation() {
		super();
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
	
	
	
	
	
	

}
