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
    
}