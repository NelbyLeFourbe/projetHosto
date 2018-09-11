package sopra.promo404.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.promo404.hopital.model.Specialite;

public interface IRepositorySpecialite extends JpaRepository<Specialite, Long> {

	@Query("select s from Specialite s left join fetch s.consultation c where s.id = :id")
	Specialite findSpecialiteByIdWithConsultation(Long id);

}
