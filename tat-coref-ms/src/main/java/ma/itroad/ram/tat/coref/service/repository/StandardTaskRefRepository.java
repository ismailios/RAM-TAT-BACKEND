package ma.itroad.ram.tat.coref.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.FlightTypeRef;
import ma.itroad.ram.tat.coref.service.domain.StandardTaskRef;
import ma.itroad.ram.tat.coref.service.domain.enumeration.FlightTypeEnum;

/**
 * Spring Data SQL repository for the StandardTaskRef entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StandardTaskRefRepository extends JpaRepository<StandardTaskRef,Long> {


    @Query(value="select distinct s from StandardTaskRef s join s.task taskRef join taskRef.tatTypes t " +
            "  join taskRef.refFlightTypes ft  " +
            " where s.task=taskRef and s.flightType like :aircraftType  and t.tat =:tatType" +
            "  and ft in :flightType" +
            "  and upper(taskRef.type)!='EXCEPTIONNELLE' ") //and upper(taskRef.type)='PRINCIPALE'
    List<StandardTaskRef> getPrincipalTasksByTatFlightAircraft(@Param("aircraftType") FlightTypeEnum flightType,
                                                               @Param("tatType") String tatType,
                                                               @Param("flightType")  List<FlightTypeRef> flightTypes);


    @Query("select s from StandardTaskRef s join s.task taskRef where taskRef.id=:taskId")
    List<StandardTaskRef> findByTaskId(@Param("taskId") long taskId);
}

