package sopra.promo404.hopital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Medecin {
	@Id
	@GeneratedValue
	private Long id;
	private int version;
	private String nom;
	private String prenom;
	private Convention conventionne;
	private boolean carteVitale;
	private boolean cmu;

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

}
