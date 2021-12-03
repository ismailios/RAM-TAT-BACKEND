package ma.itroad.ram.tat.coref.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.EquipmentRef;

/**
 * Spring Data SQL repository for the EquipmentRef entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EquipmentRefRepository extends JpaRepository<EquipmentRef,Long> {}
