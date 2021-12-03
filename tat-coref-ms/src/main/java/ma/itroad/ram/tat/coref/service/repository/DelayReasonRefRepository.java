package ma.itroad.ram.tat.coref.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.DelayReasonRef;

/**
 * Spring Data SQL repository for the DelayReasonRef entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DelayReasonRefRepository extends JpaRepository<DelayReasonRef,Long> {
    @Query("select d from DelayReasonRef d where d.task.id= :taskId")
    List<DelayReasonRef> getDelayReasonListByTask(@Param("taskId")Long id);
}
