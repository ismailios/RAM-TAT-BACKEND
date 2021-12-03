package ma.itroad.ram.tat.coref.service.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import ma.itroad.core.repository.BaseJpaRepository;
import ma.itroad.ram.tat.coref.service.domain.AircraftRef;

/**
 * Spring Data SQL repository for the AircraftRef entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AircraftRefRepository extends JpaRepository<AircraftRef,Long> {
	AircraftRef findByCode(String Code);
}
