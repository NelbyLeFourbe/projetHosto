package sopra.promo404.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.promo404.hopital.model.Secretaire;

public interface IRepositorySecretaire extends JpaRepository<Secretaire, Long> {

	@Query("select s from Secretaire s")
	List<Secretaire> findAllSecretaire();
	
}