package sopra.promo404.hopital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Secretaire {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Column(length = 100)
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(length = 100)
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@Enumerated
	@Column(name = "civility", length = 100)
	@JsonView(Views.ViewCommon.class)
	private Civilite civilite;
	@JsonView(Views.ViewCommon.class)
	@Column(length = 100)
	private boolean enPause;
	@JsonView(Views.ViewFileAttente.class)
	@OneToMany(mappedBy = "secretaire", fetch = FetchType.LAZY)
	private List<FileAttente> filesAttente = new ArrayList<>();

	public Secretaire() {
		super();
	}

	

	public Secretaire(Long id, String nom, int version, String prenom, Civilite civilite, boolean enPause,
			List<FileAttente> filesAttente) {
		super();
		this.id = id;
		this.nom = nom;
		this.version = version;
		this.prenom = prenom;
		this.civilite = civilite;
		this.enPause = enPause;
		this.filesAttente = filesAttente;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public boolean isEnPause() {
		return enPause;
	}

	public void setEnPause(boolean enPause) {
		this.enPause = enPause;
	}

	public List<FileAttente> getFilesAttente() {
		return filesAttente;
	}

	public void setFilesAttente(List<FileAttente> filesAttente) {
		this.filesAttente = filesAttente;
	}

}
