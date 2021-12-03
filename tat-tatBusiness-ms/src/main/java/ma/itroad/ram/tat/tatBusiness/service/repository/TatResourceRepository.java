package ma.itroad.ram.tat.tatBusiness.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.tatBusiness.service.domain.TatResource;

@Repository
public interface TatResourceRepository extends JpaRepository<TatResource, Long> {

	List<TatResource> findByTatId(Long tatId);

	List<TatResource> findByTatIdAndResourceId(Long tatId, Long resourceId);
	
	

}
