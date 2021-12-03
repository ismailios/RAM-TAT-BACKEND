package ma.itroad.ram.tat.thirdPartyConnectors.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import feign.FeignException;
import ma.itroad.ram.tat.thirdPartyConnectors.service.domain.Flight;
import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.ChangerRootDto;
import ma.itroad.ram.tat.thirdPartyConnectors.service.proxy.FlightChangeRepository;
import ma.itroad.ram.tat.thirdPartyConnectors.service.proxy.FlightRepository;

@RestController
public class FlightResource {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	FlightChangeRepository flightChangeRepository;

	@GetMapping("/flight")
	public List<Flight> getAllFlights() {
		System.out.println("get from 3rd party");
		return flightRepository.findAll();
	}

	@GetMapping("/flightChanges")
	public ChangerRootDto getAllChanges() {
		try {
			return flightChangeRepository.findAllChanges();
		} catch (FeignException ex) {
			System.out.println("Exception status");
			HttpStatus status = HttpStatus.resolve(ex.status());
			System.out.println(status);
			System.out.println("Exception content");
			System.out.println(ex.contentUTF8());
			System.out.println("response body");
			System.out.println(ex.responseBody());
			return null;
		}
	}

//		ChangerRootDto myRoot= new ChangerRootDto();
//		try{
//			System.out.println("start");
//			myRoot=flightRepository.findAllChanges();
//			System.out.println("message : " );
//			System.out.println(myRoot.toString());
//			return  myRoot;
//		}
//		catch (Exception e ) {
//			System.out.println("FAILED exception: "+e.toString());
//			System.out.println("FAILED root: ");
//			return null;
//		}
}
