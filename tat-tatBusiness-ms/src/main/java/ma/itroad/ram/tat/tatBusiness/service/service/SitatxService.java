package ma.itroad.ram.tat.tatBusiness.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.FlightSitatx;
import ma.itroad.ram.tat.tatBusiness.service.domain.OndaInfo;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.sitatx.FlightSitatxDto;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.sitatx.RootSitatx;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.FlightSitatxMapper;
import ma.itroad.ram.tat.tatBusiness.service.repository.SitatxRepository;

@Service
public class SitatxService {

	@Autowired
	SitatxRepository sitatxRepository;

	@Autowired
	FlightSitatxMapper flightSitatxMapper;

	public void saveSitatexMessage(RootSitatx rootSitatx) {
        System.out.println("start saving sitatx");
		List<FlightSitatxDto> sitatxDtomessages = rootSitatx.getSitatx().getFlights();
		List<FlightSitatx> sitatxmessages = flightSitatxMapper.toEntity(sitatxDtomessages);

		sitatxRepository.saveAll(sitatxmessages);

	}

	
	public FlightSitatx findOneVol(String date, String departure, String volno) {
		
		
		

		FlightSitatx flightSitatx = sitatxRepository.findOneVol(date, departure, volno);

		return flightSitatx;

	}
}
