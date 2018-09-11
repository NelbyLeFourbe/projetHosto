package sopra.promo404.hopital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Secretaire {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length=100)
    private String nom;
    @Column(length=100)
    private Civilite civilite;
    @Column(length=100)
    private boolean enPause;
    
}