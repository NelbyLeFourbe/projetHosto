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

@Entity
public class FileAttente {

	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 100)
	private int capacite;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "secretaire_id")
	private Secretaire secretaire;
	@OneToMany(mappedBy = "fileAttente", fetch=FetchType.EAGER)
	private List<Patient> patients = new ArrayList();

	public FileAttente() {
		super();
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
