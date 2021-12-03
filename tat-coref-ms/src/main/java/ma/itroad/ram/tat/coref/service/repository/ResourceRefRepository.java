package ma.itroad.ram.tat.coref.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.ResourceRef;

/**
 * Spring Data SQL repository for the ResourceRef entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ResourceRefRepository extends JpaRepository<ResourceRef,Long> {

    @Query("select role from ResourceRef where username=?1")
    String findRoleByUsername(String username);
}
