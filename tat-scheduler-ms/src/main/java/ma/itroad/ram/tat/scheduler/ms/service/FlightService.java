package ma.itroad.ram.tat.scheduler.ms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.scheduler.ms.domain.NetlineFlightMessage;
import ma.itroad.ram.tat.scheduler.ms.repository.NetlineFlightRepository;
import ma.itroad.ram.tat.scheduler.ms.service.dto.NetlineFlightMessageDto;
import ma.itroad.ram.tat.scheduler.ms.service.mapper.NetlineFlightMessageMapper;



@Service
public class FlightService {
	 private final Logger log = LoggerFactory.getLogger(FlightService.class);


	@Autowired
	NetlineFlightMessageMapper netlineFlightMessageMapper;
	
	@Autowired
	NetlineFlightRepository netlineFlightRepository;
	public void save(NetlineFlightMessageDto netlineFlightMessageDto) {
       log.debug("Request to save Flight : {}", netlineFlightMessageDto);

       NetlineFlightMessage netlineFlightMessage = netlineFlightMessageMapper.toEntity(netlineFlightMessageDto);
       
       netlineFlightMessage = netlineFlightRepository.save(netlineFlightMessage);
   }

	
	public void deleteFlight(NetlineFlightMessage netlineFlightMessage) {
		netlineFlightRepository.delete(netlineFlightMessage);
	}
	
	

	
	

}