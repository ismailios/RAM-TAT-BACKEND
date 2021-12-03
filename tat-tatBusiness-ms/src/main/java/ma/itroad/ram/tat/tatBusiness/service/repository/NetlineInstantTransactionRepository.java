package ma.itroad.ram.tat.tatBusiness.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.itroad.ram.tat.tatBusiness.service.domain.NetlineInstantTransaction;

@Repository
public interface NetlineInstantTransactionRepository extends JpaRepository<NetlineInstantTransaction,Long> {

}
