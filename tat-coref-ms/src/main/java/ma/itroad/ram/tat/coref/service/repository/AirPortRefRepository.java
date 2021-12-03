package ma.itroad.ram.tat.coref.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.AirPortRef;

/**
 * Spring Data SQL repository for the AirPortRef entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AirPortRefRepository extends JpaRepository<AirPortRef,Long> {

	Optional<AirPortRef> findByName(String code);
	

}
