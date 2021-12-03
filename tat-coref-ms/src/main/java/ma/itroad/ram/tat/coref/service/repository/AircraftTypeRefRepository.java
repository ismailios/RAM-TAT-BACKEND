package ma.itroad.ram.tat.coref.service.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.itroad.core.repository.BaseJpaRepository;
import ma.itroad.ram.tat.coref.service.domain.AircraftRef;
import ma.itroad.ram.tat.coref.service.domain.AircraftTypeRef;

/**
 * Spring Data SQL repository for the AircraftTypeRef entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AircraftTypeRefRepository extends JpaRepository<AircraftTypeRef,Long> {
	AircraftTypeRef findById(long id);

	@Query(value="select distinct tatMaxDuration from AircraftTypeRef a where a.name =:subType ")
	long tatMax(@Param("subType") String subType);

	@Query(value="Select distinct airCraftType from AircraftTypeRef a where a.name =:subType")
    String aircraftType(@Param("subType") String acSubtype);
}
