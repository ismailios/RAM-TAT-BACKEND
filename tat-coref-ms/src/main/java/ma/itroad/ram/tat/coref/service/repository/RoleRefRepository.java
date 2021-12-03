package ma.itroad.ram.tat.coref.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.RoleRef;

/**
 * Spring Data SQL repository for the RoleRef entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RoleRefRepository extends JpaRepository<RoleRef,Long> {

}
