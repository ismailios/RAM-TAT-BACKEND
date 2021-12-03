package ma.itroad.ram.tat.thirdPartyConnectors.service.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ma.itroad.ram.tat.thirdPartyConnectors.service.domain.Flight;

@FeignClient(name = "Netline", url = "${netline.flight.url}")
public interface FlightRepository {

	@GetMapping("/")
	List<Flight> findAll();

}
