package ma.itroad.ram.tat.tatBusiness.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import ma.itroad.ram.tat.tatBusiness.service.domain.OndaInfo;

@Repository
public interface OndaRepository extends JpaRepository<OndaInfo, Long> {

	@Query("SELECT v FROM OndaInfo v WHERE v.dATEMVT = :date and v.iMMAT= :immat and v.vOLNO like %:volno% ")
	OndaInfo findOneVol(@Param("date") String date, @Param("immat") String immat,@Param("volno") String volno);
	
}
