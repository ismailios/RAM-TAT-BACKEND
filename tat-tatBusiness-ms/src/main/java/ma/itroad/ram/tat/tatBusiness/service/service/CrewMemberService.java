package ma.itroad.ram.tat.tatBusiness.service.service;

import ma.itroad.ram.tat.tatBusiness.service.repository.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewMemberService {

    @Autowired
    CrewRepository crewRepository;


    //crewRepository.checkTatAffected(tatDto.getId(),userRole)>0


    public boolean checkTatAssigned(long tatId,String userRole){
        return (crewRepository.checkTatAssigned(tatId, userRole) > 0);

    }
}
