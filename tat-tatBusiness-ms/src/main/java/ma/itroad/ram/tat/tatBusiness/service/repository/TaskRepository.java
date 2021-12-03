package ma.itroad.ram.tat.tatBusiness.service.repository;

import ma.itroad.ram.tat.tatBusiness.service.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByTatId(Long tatId);

    @Query("select distinct t from Task t  where t.tatId=:tatId and " +
            "( :phase is null or phase like %:phase% ) " +
            "and (:groupTask is null or t.groupTask like :groupTask) "+
            "and (:status is null or t.status like :status) "+
            "order by t.taskOrder asc ")
    List<Task> findByTatIdOrderByGroupTask(@Param("tatId") long tatId,
                                           @Param("phase") String phase,
                                           @Param("groupTask")String groupTask,
                                           @Param("status")String status);

    @Query("select distinct t from Task t join t.roles r where :role = r.name " +
            "and t.tatId=:tatId and (:phase is null  or t.phase like %:phase% )" +
            "and (:groupTask is null or t.groupTask like :groupTask) "+
            "and (:status is null or t.status like :status) "+
            "and :crewPhase like concat('%',t.phase,'%') "+
            " order by  t.taskOrder asc")
    List<Task> findByTatIdAndUserRole(@Param("tatId") long tatId,
                                      @Param("role") String userRole,
                                      @Param("phase") String phase,
                                      @Param("groupTask")String groupTask,
                                      @Param("status")String status,
                                      @Param("crewPhase") String crewPhase);

    @Query("select t from Task t where t.tatId=id and t.status='NON_STARTED'")
    List<Task> findNonStartedTasksByTatId(Long id);

    @Query("select t from Task t where t.tatId=:id and t.notApplicable=false")
    List<Task> findApplicableTasksByTatId(@Param("id") long id);

    //tatProgress
    @Query("select 1.0 * SUM(t.progress*t.duration)/ (1.0 * SUM(t.duration)) from Task t where t.tatId=:tatId and t.notApplicable=false")
    float findTatProgress(@Param("tatId") long tatId);

    @Query("select max(endDateCalculated)" +
            " from Task t where t.tatId=:tatId and t.notApplicable=false")
    LocalDateTime getEndTat(@Param("tatId") long tatId);

    @Query("select min(startDateCalculated)" +
            " from Task t where t.tatId=:tatId and t.notApplicable=false")
    LocalDateTime getStartTat(@Param("tatId") long tatId);

    @Query("select t from Task t where t.tatId=:tatId and t.refId=:taskToEnd")
    Task getTatTaskByRefId(@Param("taskToEnd") long taskToEnd, @Param("tatId") long tatId);

    @Query("select max(t.progress) from Task t join t.roles r where :role = r.name and t.tatId=:tatId")
    int getMaxProgressByRoleAndTat(@Param("tatId") long tatId,@Param("role")String role);

    @Query("select t from Task t where t.id= :taskId")
    Optional<Task> findById(@Param("taskId") long taskId);


///   @Query("select SUM(t.progress*t.duration) from Task t where t.tatId=:tatId")
///    long tatProgressDuration(@Param("tatId") long tatId);
///
///   @Query("select SUM(t.duration) from Task t where t.tatId=:tatId")
//    long tatDuration(@Param("tatId") long tatId);
}
