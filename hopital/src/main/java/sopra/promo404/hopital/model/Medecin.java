package sopra.promo404.hopital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Medecin {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@JsonView(Views.ViewCommon.class)
	private Convention conventionne;
	@JsonView(Views.ViewCommon.class)
	private boolean carteVitale;
	@JsonView(Views.ViewCommon.class)
	private boolean cmu;
	@Transient
	@OneToMany(mappedBy = "medecin", fetch=FetchType.EAGER)
	@JsonView(Views.ViewMedecinWithSpecialite.class)
	private List<Specialite> specialites = new ArrayList<>();
	@Transient
	@OneToMany(mappedBy = "medecin", fetch=FetchType.EAGER)
	private List<FileAttente> fileAttentes = new ArrayList<>();
	private Salle salle;

	public Medecin() {
		super();
	}

	public Medecin(String nom, String prenom, Convention conventionne, boolean carteVitale, boolean cmu) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.conventionne = conventionne;
		this.carteVitale = carteVitale;
		this.cmu = cmu;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Convention getConventionne() {
		return conventionne;
	}

	public void setConventionne(Convention conventionne) {
		this.conventionne = conventionne;
	}

	public boolean isCarteVitale() {
		return carteVitale;
	}

	public void setCarteVitale(boolean carteVitale) {
		this.carteVitale = carteVitale;
	}

	public boolean isCmu() {
		return cmu;
	}

	public void setCmu(boolean cmu) {
		this.cmu = cmu;
	}

	public List<Specialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<Specialite> specialites) {
		this.specialites = specialites;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

}
