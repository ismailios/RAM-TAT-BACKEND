package ma.itroad.ram.tat.scheduler.ms.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import ma.itroad.ram.tat.scheduler.ms.service.dto.NetlineFlightMessageDto;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.ChangerRootDto;

@FeignClient(name = "${service.business.name}", url = "${service.business.host}")
public interface FlightServicePost {

	@PostMapping("${feign.uri.post_flights}")
	public void postAllFlights(List<NetlineFlightMessageDto> netlineFlightMessageDto);

	// new one by elaidi

	@PostMapping("${feign.uri.post_changes}")
	public void postTransactionChange(ChangerRootDto changers);

}
