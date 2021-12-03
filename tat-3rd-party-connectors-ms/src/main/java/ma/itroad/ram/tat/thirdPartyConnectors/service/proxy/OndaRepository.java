
package ma.itroad.ram.tat.thirdPartyConnectors.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.onda.RootOnda;

@FeignClient(name = "ondaInfo", url = "${onda.info.uri}")
public interface OndaRepository {

	@GetMapping("/")
	RootOnda findAll();

}