package ma.itroad.ram.tat.thirdPartyConnectors.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.ChangerRootDto;

@FeignClient(name = "local", url = "${netline.changeFlights.url}")
public interface FlightChangeRepository {

	@GetMapping("")
	ChangerRootDto findAllChanges();

}
