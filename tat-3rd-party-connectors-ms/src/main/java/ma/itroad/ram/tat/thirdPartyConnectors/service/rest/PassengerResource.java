package ma.itroad.ram.tat.thirdPartyConnectors.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.passengerList.RootPassengerList;
import ma.itroad.ram.tat.thirdPartyConnectors.service.proxy.PassengerListRepository;


@RestController
@RequestMapping("/3rd-party-connectors")
public class PassengerResource {

	@Autowired
	PassengerListRepository passengerListRepository;
	
	@PostMapping("/passenger")
	public RootPassengerList getPassengerList(@RequestParam(name = "boardPoint") String boardPoint, 
			@RequestParam(name = "departureDate") String departureDate, 
			@RequestParam(name = "flightNumber") String flightNumber, 
			@RequestParam(name = "getPassengerList") String getPassengerList,
			@RequestParam(name = "getPassengerProcess") String getPassengerProcess,
			@RequestParam(name = "getPtm") String getPtm,
			@RequestParam(name = "getSpeReq") String getSpeReq,
			@RequestParam(name = "marketingCarrier") String marketingCarrier)
	{
		
		return passengerListRepository.findPassengerList(boardPoint, departureDate, flightNumber, getPassengerList, getPassengerProcess, getPtm, getSpeReq, marketingCarrier);
		
		
	}
	
}
