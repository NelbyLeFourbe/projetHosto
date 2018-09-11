package sopra.promo404.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import sopra.promo404.hopital.model.FileAttente;
import sopra.promo404.hopital.model.Secretaire;


public interface IRepositoryFileAttente {

	
	
	@Query("select f from FileAttente f")
	List<FileAttente> findAllFileAttente();
	
}
