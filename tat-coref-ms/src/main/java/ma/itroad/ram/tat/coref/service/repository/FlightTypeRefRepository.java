package ma.itroad.ram.tat.coref.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.FlightTypeRef;
import ma.itroad.ram.tat.coref.service.domain.enumeration.LegEnum;

/**
 * Spring Data SQL repository for the FlightTypeRef entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FlightTypeRefRepository extends JpaRepository<FlightTypeRef,Long> {

    @Query(value="select f from FlightTypeRef f where leg=:legType" )
    List<FlightTypeRef> getFlightTypeByLegType(@Param("legType") LegEnum legType);
}
