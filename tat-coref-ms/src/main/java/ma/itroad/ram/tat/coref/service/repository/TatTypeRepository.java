package ma.itroad.ram.tat.coref.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.TatType;

/**
 * Spring Data SQL repository for the TatType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TatTypeRepository extends JpaRepository<TatType,Long> {}
