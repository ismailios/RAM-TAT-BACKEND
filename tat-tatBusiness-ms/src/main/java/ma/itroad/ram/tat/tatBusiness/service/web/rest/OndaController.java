package ma.itroad.ram.tat.tatBusiness.service.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.itroad.ram.tat.tatBusiness.ms.service.dto.changer.onda.RootOndaDto;
import ma.itroad.ram.tat.tatBusiness.ms.service.dto.changer.onda.OndaInfoDto;
import ma.itroad.ram.tat.tatBusiness.service.domain.OndaInfo;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.OndaInfoMapper;
import ma.itroad.ram.tat.tatBusiness.service.service.OndaService;

@RestController
@RequestMapping("/tatBusiness")
public class OndaController {

	@Autowired
	OndaService ondaService;
	
	@Autowired
	OndaInfoMapper ondaInfoMapper;

	@PostMapping("/OndaInfo")
	RootOndaDto SaveOndaInfo(@RequestBody RootOndaDto rootOnda) {

		ondaService.saveOndaInfo(rootOnda);

		return rootOnda;

	}

	@GetMapping("/OndaInfo")
	OndaInfoDto FindOneVol(@RequestParam(name = "date", required = false, defaultValue = "") String date,
			@RequestParam(name = "immat", required = false, defaultValue = "") String immat,
			@RequestParam(name = "volno", required = false, defaultValue = "") String volno) {

		OndaInfo ondaInfo = ondaService.findOneVol(date, immat, volno);
		OndaInfoDto ondaInfoDto = ondaInfoMapper.toDto(ondaInfo);
		

		return ondaInfoDto;

	}
}