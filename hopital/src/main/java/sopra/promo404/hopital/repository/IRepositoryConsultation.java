package sopra.promo404.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.promo404.hopital.model.Consultation;
import sopra.promo404.hopital.model.Patient;


public interface IRepositoryConsultation extends JpaRepository<Consultation, Long> {

	List<Consultation> findAllConsultation();
	@Query("select c from Consultation c left join fetch c.salles s where c.id = :id")
	Patient findByIdWithSalles(Long id);

}
