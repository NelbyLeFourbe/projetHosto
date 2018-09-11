package sopra.promo404.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.promo404.hopital.model.Patient;

public interface IRepositoryPatient extends JpaRepository<Patient, Long> {

}
