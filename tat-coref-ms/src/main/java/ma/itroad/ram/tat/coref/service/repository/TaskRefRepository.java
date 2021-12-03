package ma.itroad.ram.tat.coref.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.TaskRef;
import ma.itroad.ram.tat.coref.service.domain.enumeration.GroupTaskEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.PhaseEnum;

/**
 * Spring Data SQL repository for the TaskRef entity.
 */
@Repository
public interface TaskRefRepository extends JpaRepository<TaskRef,Long> {
    @Query(
        value = "select distinct taskRef from TaskRef taskRef left join fetch taskRef.tatTypes left join fetch taskRef.delayReasons left join fetch taskRef.roles",
        countQuery = "select count(distinct taskRef) from TaskRef taskRef"
    )
    Page<TaskRef> findAllWithEagerRelationships(Pageable pageable);

    List<TaskRef> findAll();

    @Query(
        "select distinct taskRef from TaskRef taskRef left join fetch taskRef.tatTypes left join fetch taskRef.delayReasons left join fetch taskRef.roles"
    )
    List<TaskRef> findAllWithEagerRelationships();

    @Query(
        "select taskRef from TaskRef taskRef left join fetch taskRef.tatTypes left join fetch taskRef.delayReasons left join fetch taskRef.roles where taskRef.id =:id"
    )
    Optional<TaskRef> findOneWithEagerRelationships(@Param("id") Long id);

    @Query(value="select distinct taskRef from TaskRef taskRef ," +
            " StandardTaskRef s  " +
            "  where s.task=taskRef " +
                  " and s.flightType='MP' ")
    List<TaskRef> getTasksByTatFlightAircraft(long tatTypeLong, String aircraftType);

    @Query("select taskRef from TaskRef taskRef where taskRef.type ='EXCEPTIONNELLE' " +
            "and (taskRef.phase=:phase or :phase='ARRIVEE_DEPART') and (taskRef.groupTask=:groupTask or :groupTask='ALL') ")
    List<TaskRef> getAllExceptionalTasks(@Param("phase") PhaseEnum phase, @Param("groupTask") GroupTaskEnum groupTask);


//    select distinct taskRef from TaskRef taskRef , StandardTaskRef s  where s.task=taskRef
//    and s.flightType='MP'
}
