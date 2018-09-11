package sopra.promo404.hopital.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import sopra.promo404.hopital.model.FileAttente;



public interface IRepositoryFileAttente {

	fghfdhdfhdgdfg
	
	@Query("select f from FileAttente f")
	List<FileAttente> findAllFileAttente();
	
  }
