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
    private Long id;
    @Column(length=100)
    private String nom;
    @Enumerated
	@Column(name = "civility", length = 100)
	@JsonView(Views.ViewCommon.class)
    private Civilite civilite;
    @Column(length=100)
    private boolean enPause;
    @JsonView(Views.ViewFileAttente.class)
    @OneToMany(mappedBy = "secretaire", fetch=FetchType.EAGER)
    private List<FileAttente> filesAttente = new ArrayList<>();
	
    public Secretaire() {
		super();
	}

	public Secretaire(Long id, String nom, Civilite civilite, boolean enPause, List<FileAttente> filesAttente) {
		super();
		this.id = id;
		this.nom = nom;
		this.civilite = civilite;
		this.enPause = enPause;
		this.filesAttente = filesAttente;
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
