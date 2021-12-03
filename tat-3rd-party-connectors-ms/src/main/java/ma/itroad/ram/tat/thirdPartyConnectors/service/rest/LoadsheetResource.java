package ma.itroad.ram.tat.thirdPartyConnectors.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.itroad.ram.tat.thirdPartyConnectors.service.dto.changer.loadSheet.LoadSheet;
import ma.itroad.ram.tat.thirdPartyConnectors.service.proxy.LoadSheetRepository;

@RestController
@RequestMapping("/3rd-party-connectors")
public class LoadsheetResource {

	@Autowired
	LoadSheetRepository loadSheetRepository;

	@GetMapping("/loadSheet")
	public List<LoadSheet> getOndaInfo() {
		System.out.println("get from 3rd party");
		return loadSheetRepository.findSome();

	}
	
}
