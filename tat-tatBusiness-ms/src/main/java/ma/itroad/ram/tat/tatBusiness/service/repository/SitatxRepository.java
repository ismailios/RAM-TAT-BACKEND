package ma.itroad.ram.tat.tatBusiness.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.tatBusiness.service.domain.FlightSitatx;

@Repository
public interface SitatxRepository extends JpaRepository<FlightSitatx, Long> {

	@Query("SELECT s FROM FlightSitatx s WHERE s.dateOfOrigin = :date and s.departure= :departure and s.flightNo like %:volno% ")
	FlightSitatx findOneVol(@Param("date") String date, @Param("departure") String departure,@Param("volno") String volno);
	
}
