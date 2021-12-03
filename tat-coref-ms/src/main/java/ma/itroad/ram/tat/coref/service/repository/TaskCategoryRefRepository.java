package ma.itroad.ram.tat.coref.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.TaskCategoryRef;

/**
 * Spring Data SQL repository for the TaskCategoryRef entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TaskCategoryRefRepository extends JpaRepository<TaskCategoryRef,Long> {}
