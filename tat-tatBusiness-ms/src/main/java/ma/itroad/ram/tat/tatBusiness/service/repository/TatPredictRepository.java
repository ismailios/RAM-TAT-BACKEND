package ma.itroad.ram.tat.tatBusiness.service.repository;

import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.domain.TatPredict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TatPredictRepository extends JpaRepository<TatPredict,Long> {
}
