package ma.itroad.ram.tat.tatBusiness.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.tatBusiness.service.domain.TatEquipment;

@Repository
public interface TatEquipmentRepository extends JpaRepository<TatEquipment, Long>{

	
	List<TatEquipment> findByTatId(Long tatId);

	List<TatEquipment> findByTatIdAndEquipmentId(Long tatId, Long resourceId);
}
