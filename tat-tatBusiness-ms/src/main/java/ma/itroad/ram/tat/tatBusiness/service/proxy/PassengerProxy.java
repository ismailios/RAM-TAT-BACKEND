package ma.itroad.ram.tat.tatBusiness.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.itroad.ram.tat.tatBusiness.service.dto.changer.passengerList.RootPassengerList;

@FeignClient(name = "PassengerDto", url = "${third-party-ms-url}")
public interface PassengerProxy {

	@PostMapping(value = "/3rd-party-connectors/passenger")
	public RootPassengerList findPassengerList(@RequestParam(name = "boardPoint") String boardPoint,
			@RequestParam(name = "departureDate") String departureDate,
			@RequestParam(name = "flightNumber") String flightNumber,
			@RequestParam(name = "getPassengerList") String getPassengerList,
			@RequestParam(name = "getPassengerProcess") String getPassengerProcess,
			@RequestParam(name = "getPtm") String getPtm, @RequestParam(name = "getSpeReq") String getSpeReq,
			@RequestParam(name = "marketingCarrier") String marketingCarrier);
}
