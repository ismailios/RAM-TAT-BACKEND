package ma.itroad.ram.tat.tatBusiness.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.tatBusiness.service.domain.CrewMember;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrewRepository extends JpaRepository<CrewMember, Long> {

    @Query("select c from CrewMember c where c.tat.id =:tatId and empNo=:userId  and type!='auto' ")
    List<CrewMember> checkIfManuallyAssignedToTat(@Param("tatId") long tatId, @Param("userId") int userId);

    @Query("select c from CrewMember c where c.tat.id =:tatId and empNo=:userId")
    List<CrewMember> checkIfAssignedToTat(@Param("tatId") long tatId, @Param("userId") int userId);

//    @Query("select count(c) from CrewMember c where c.tat.id=:tatId and type=:role")
//    int checkTatAffected(@Param("tatId") long tatId, @Param("userId") int userId);

    @Query("select distinct phase from CrewMember c where c.tat.id=:tatId and empNo=:userId")
    List<String> getCrewPhase(  @Param("tatId") long tatId,
                                @Param("userId") int userId);

	CrewMember findByTat(Tat tat);

	List<CrewMember> findByTatAndEmpNo(Tat tat, int empNo);
	
	@Query("select count(c) from CrewMember c where c.tat.id=:tatId and type=:role")
    int checkTatAssigned(@Param("tatId") long tatId, @Param("role") String role);

	@Query("select empNo from CrewMember c where c.crewCat in :taskRoles and c.tat.id = :tatId ")
    List<Integer> getTaskOwnerEmpno(@Param("taskRoles") List<String> taskRoles, @Param("tatId") long tatId);



//	@Query("select c from CrewMember c where c.tat.id =:tatId and empNo=:userId")
//    List<CrewMember> checkIfAssignedToTat2(@Param("tatId") long tatId, @Param("userId") int userId);

}
