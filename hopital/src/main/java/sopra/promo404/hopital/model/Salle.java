package sopra.promo404.hopital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Salle {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@OneToOne(mappedBy = "salle", fetch=FetchType.LAZY)
	private Medecin medecin;
	@OneToMany
	private List<Consultation> consultations = new ArrayList<>();

	public Salle() {
		super();
	}

	

	public Salle(Long id, int version, String nom, Medecin medecin, List<Consultation> consultations) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.medecin = medecin;
		this.consultations = consultations;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

}
