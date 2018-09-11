package sopra.promo404.hopital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Specialite {
	@Id
	@GeneratedValue
	private Long id;
	private int version;
	private String libelle;
	private Float tarif;

	public Specialite() {
		super();
	}

	public Specialite(String libelle, Float tarif) {
		super();
		this.libelle = libelle;
		this.tarif = tarif;
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

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getTarif() {
		return tarif;
	}

	public void setTarif(Float tarif) {
		this.tarif = tarif;
	}

}
