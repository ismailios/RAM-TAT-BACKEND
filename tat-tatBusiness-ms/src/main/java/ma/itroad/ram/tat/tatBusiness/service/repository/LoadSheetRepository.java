package ma.itroad.ram.tat.tatBusiness.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.tatBusiness.service.domain.LoadSheet;

@Repository
public interface LoadSheetRepository extends JpaRepository<LoadSheet, Long>{

	
	@Query("SELECT l FROM LoadSheet l WHERE l.dATEORIGIN= :date and l.fLIGHT= :volno and l.eSCALE= :immat ")
	LoadSheet findOneVol(@Param("date") String date, @Param("volno") String volno, @Param("immat") String immat);
}
