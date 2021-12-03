package ma.itroad.ram.tat.tatBusiness.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.tatBusiness.service.domain.Passenger;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

	@Query("select p from Passenger p LEFT JOIN p.passengerInfo pi LEFT JOIN pi.tat t where (t.id= :id) and ((:firstName is null OR p.firstName like %:firstName%)) and ((:lastName is null OR p.firstName like %:lastName%)) and ((:type is null OR p.firstName like %:type%)) and ((:classe is null OR p.firstName like %:classe%)) and ((:seat is null OR p.firstName like %:seat%)) and ((:specialReq is null OR p.firstName like %:specialReq%)) and ((:status is null OR p.firstName like %:status%))"

			
			)
	List<Passenger> passengerFilter(@Param("id") Long id,
			@Param("firstName") String firstName,
			@Param("lastName") String lastName,
			@Param("type") String type,
			@Param("classe") String classe,
			@Param("seat") String seat,
			@Param("specialReq") String specialReq,
			@Param("status") String status);
	
}
