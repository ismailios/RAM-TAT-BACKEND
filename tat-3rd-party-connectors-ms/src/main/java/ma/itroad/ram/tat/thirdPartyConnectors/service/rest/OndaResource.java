package ma.itroad.ram.tat.thirdPartyConnectors.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.onda.RootOnda;
import ma.itroad.ram.tat.thirdPartyConnectors.service.proxy.OndaRepository;

@RestController
@RequestMapping("/3rd-party-connectors")
public class OndaResource {

	@Autowired
	OndaRepository ondaRepository;

	@GetMapping("/ondaInfo")
	public RootOnda getOndaInfo() {
		System.out.println("get from 3rd party");
		return ondaRepository.findAll();

	}
}