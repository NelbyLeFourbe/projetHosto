package sopra.promo404.hopital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.formation.model.Eleve;
import sopra.promo404.formation.model.Views;





@Entity
public class Patient {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Column(length = 100)
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@Column(length = 100)
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@Column(length = 100)
	@JsonView(Views.ViewCommon.class)
	private String numeroSecuriteSocial; 
	@Enumerated
	@Column(length = 10)
	@JsonView(Views.ViewCommon.class)
	private Civilite civilite;
	@JsonView(Views.ViewConsultation.class)
	@OneToMany(mappedBy = "consultation", fetch=FetchType.EAGER)
	private List<Consultation> consultations = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn
	@JsonView(Views.ViewFileAttente.class)
	private FileAttente fileAttente; 
	
	
	

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumeroSecuriteSocial() {
		return numeroSecuriteSocial;
	}

	public void setNumeroSecuriteSocial(String numeroSecuriteSocial) {
		this.numeroSecuriteSocial = numeroSecuriteSocial;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public FileAttente getFileattente() {
		return fileAttente;
	}

	public void setFileattente(FileAttente fileattente) {
		this.fileAttente = fileattente;
	}

	public Patient() {
		super();
	}

	public Patient(String nom) {
		super();
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
