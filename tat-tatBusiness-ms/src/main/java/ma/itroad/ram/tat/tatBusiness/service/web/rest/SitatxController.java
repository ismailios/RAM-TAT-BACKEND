package ma.itroad.ram.tat.tatBusiness.service.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.itroad.ram.tat.tatBusiness.ms.service.dto.changer.onda.RootOndaDto;
import ma.itroad.ram.tat.tatBusiness.service.dto.changer.sitatx.RootSitatx;
import ma.itroad.ram.tat.tatBusiness.service.service.SitatxService;

@RestController
@RequestMapping("/tatBusiness")
public class SitatxController {

	@Autowired
	SitatxService sitatxService;
	
	@PostMapping("/sitatx")
	RootSitatx SaveSitatxMessage(@RequestBody RootSitatx rootSitatx) {

		sitatxService.saveSitatexMessage(rootSitatx);

		return rootSitatx;

	}
	
}
