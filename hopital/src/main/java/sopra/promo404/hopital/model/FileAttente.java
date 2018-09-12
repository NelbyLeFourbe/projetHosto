package sopra.promo404.hopital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class FileAttente {

	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 100)
	@JsonView(Views.ViewCommon.class)
	private int capacite;
	@JsonView(Views.ViewCommon.class)
	@Version
	private int version;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "secretaire_id")
	@JsonView(Views.ViewFileAttente.class)
	private Secretaire secretaire;
	@OneToMany(mappedBy = "fileAttente", fetch=FetchType.LAZY)
	@JsonView(Views.ViewFileAttente.class)
	private List<Patient> patients = new ArrayList<>();
	@ManyToOne
	@JsonView(Views.ViewFileAttente.class)
	private Medecin medecin;

	


	


	public FileAttente(Long id, int capacite, int version, Secretaire secretaire, List<Patient> patients,
			Medecin medecin) {
		super();
		this.id = id;
		this.capacite = capacite;
		this.version = version;
		this.secretaire = secretaire;
		this.patients = patients;
		this.medecin = medecin;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public FileAttente() {
		super();
	}

	
	public Medecin getMedecin() {
		return medecin;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public FileAttente(Long id) {
		super();
		this.id = id;
	}


	public FileAttente(Long id, int capacite, Secretaire secretaire, List<Patient> patients) {
		super();
		this.id = id;
		this.capacite = capacite;
		this.secretaire = secretaire;
		this.patients = patients;
	}

	
	
	public Secretaire getSecretaire() {
		return secretaire;
	}

	public void setSecretaire(Secretaire secretaire) {
		this.secretaire = secretaire;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	
	public FileAttente(Long id, int capacite) {
		super();
		this.id = id;
		this.capacite = capacite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

}
