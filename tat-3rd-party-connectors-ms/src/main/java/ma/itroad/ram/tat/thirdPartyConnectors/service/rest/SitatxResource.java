package ma.itroad.ram.tat.thirdPartyConnectors.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.sitatx.RootSitatx;
import ma.itroad.ram.tat.thirdPartyConnectors.service.proxy.SitatexRepository;

@RestController
@RequestMapping("/3rd-party-connectors")
public class SitatxResource {

	@Autowired
	SitatexRepository sitatexRepository;

	@GetMapping("/sitatx")
	public RootSitatx getSitatexMessage() {
		System.out.println("get from 3rd party");
		return sitatexRepository.findAll();

	}

}
