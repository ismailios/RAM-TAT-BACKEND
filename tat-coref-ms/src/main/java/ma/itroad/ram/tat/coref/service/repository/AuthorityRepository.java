package ma.itroad.ram.tat.coref.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.itroad.ram.tat.coref.service.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
