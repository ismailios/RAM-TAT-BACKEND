package ma.itroad.ram.tat.scheduler.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.itroad.ram.tat.scheduler.ms.domain.NetlineInstantTransaction;

public interface NetlineTransactionRepository extends JpaRepository<NetlineInstantTransaction,Long> {

}
