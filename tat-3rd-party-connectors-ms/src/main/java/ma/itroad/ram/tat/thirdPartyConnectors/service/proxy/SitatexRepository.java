package ma.itroad.ram.tat.thirdPartyConnectors.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.sitatx.RootSitatx;

@FeignClient(name = "sitatexInfo", url = "${sitatx.info.uri}")
public interface SitatexRepository {

	@GetMapping("/")
	RootSitatx findAll();

}
