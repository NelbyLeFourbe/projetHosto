package sopra.promo404.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.promo404.hopital.model.Patient;

public interface IRepositoryPatient extends JpaRepository<Patient, Long> {
@Query ("select p from Patient p")
	List<Patient> findAllPatient();

	
	@Query("select distinct p from Patient p join fetch p.consultations c where p.id = :id")
	Patient findPatientByIdWithConsultations(@Param("id") Long id);

}
