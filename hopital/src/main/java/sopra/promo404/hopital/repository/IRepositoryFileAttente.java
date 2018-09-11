package sopra.promo404.hopital.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.promo404.hopital.model.FileAttente;
import sopra.promo404.hopital.model.Secretaire;


public interface IRepositoryFileAttente extends JpaRepository<FileAttente, Long>{

		
	@Query("select f from FileAttente f")
	List<FileAttente> findAllFileAttente();
	
	
	@Query("select distinct f from FileAttente s left join fetch f.secretaire s where f.id = :id")
	FileAttente findFileAttenteByIdWithSecretaire(@Param("id") Long id);
  }
