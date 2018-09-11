package sopra.promo404.hopital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 100)
	private String nom;

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
