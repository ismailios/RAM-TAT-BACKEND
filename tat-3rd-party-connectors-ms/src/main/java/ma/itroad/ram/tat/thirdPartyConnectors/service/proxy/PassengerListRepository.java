package ma.itroad.ram.tat.thirdPartyConnectors.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.passengerList.RootPassengerList;


@FeignClient(name = "passengerInfo", url = "${passenger.info.uri}")
public interface PassengerListRepository {


	@PostMapping("/")
	public RootPassengerList findPassengerList(@RequestParam(name = "boardPoint") String boardPoint, 
			@RequestParam(name = "departureDate") String departureDate, 
			@RequestParam(name = "flightNumber") String flightNumber, 
			@RequestParam(name = "getPassengerList", defaultValue = "1") String getPassengerList,
			@RequestParam(name = "getPassengerProcess", defaultValue = "4") String getPassengerProcess,
			@RequestParam(name = "getPtm", defaultValue = "1") String getPtm,
			@RequestParam(name = "getSpeReq", defaultValue = "1") String getSpeReq,
			@RequestParam(name = "marketingCarrier") String marketingCarrier
);
	
}
