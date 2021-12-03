package ma.itroad.ram.tat.coref.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.coref.service.domain.UserRef;

@SuppressWarnings("unused")
@Repository
public interface UserRefRepository extends JpaRepository<UserRef,Long> {

	UserRef findByEmpno(String empno);

	
	@Query("select u from UserRef u where upper(username) like upper(:username)")
    UserRef findByUsername(@Param("username")String username);
	

}
