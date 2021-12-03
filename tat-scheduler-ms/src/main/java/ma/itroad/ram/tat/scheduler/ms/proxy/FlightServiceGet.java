package ma.itroad.ram.tat.scheduler.ms.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ma.itroad.ram.tat.scheduler.ms.dto.LoadSheet;
import ma.itroad.ram.tat.scheduler.ms.service.dto.NetlineFlightMessageDto;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.ChangerRootDto;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.onda.RootOnda;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.sitatx.RootSitatx;

@FeignClient(name = "${service.3rd-party-connectors.name}", url = "${service.3rd-party-connectors.host}")
public interface FlightServiceGet {
	
	@GetMapping("${feign.uri.get_flights}")
	public List<NetlineFlightMessageDto> getAllFlights();

	// new one by elaidi
	@GetMapping("${feign.uri.get_changes}")
	public ChangerRootDto getChangeTransactions();
	
	@GetMapping("${feign.uri.get_onda}")
	public RootOnda getOndaInfo();
	
	@GetMapping("${feign.uri.get_loadSheet}")
	public List<LoadSheet> getLoadSheet();
	
	@GetMapping("${feign.uri.get_sitatx}")
	public RootSitatx getSitatxMessage();
	
	

}
