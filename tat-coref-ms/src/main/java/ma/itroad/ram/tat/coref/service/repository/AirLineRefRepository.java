package ma.itroad.ram.tat.coref.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.AirLineRef;

/**
 * Spring Data SQL repository for the AirLineRef entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AirLineRefRepository extends JpaRepository<AirLineRef,Long> {}
