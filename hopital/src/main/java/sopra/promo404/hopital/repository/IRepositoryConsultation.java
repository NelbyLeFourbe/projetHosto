package sopra.promo404.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.promo404.hopital.model.Consultation;
import sopra.promo404.hopital.model.Patient;


public interface IRepositoryConsultation extends JpaRepository<Consultation, Long> {

	List<Consultation> findAllConsultation();

	Patient findByIdWithSalles(Long id);

}
