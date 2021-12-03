package ma.itroad.ram.tat.tatBusiness.service.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.itroad.ram.tat.tatBusiness.ms.service.dto.changer.onda.RootOndaDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.loadSheet.LoadSheetDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.OndaInfoMapper;
import ma.itroad.ram.tat.tatBusiness.service.service.LoadSheetService;
import ma.itroad.ram.tat.tatBusiness.service.service.OndaService;

@RestController
@RequestMapping("/tatBusiness")
public class LoadSheetController {

	
	@Autowired
	LoadSheetService loadSheetService;
	

	
	@PostMapping("/LoadSheet")
	List<LoadSheetDto> SaveOndaInfo(@RequestBody List<LoadSheetDto> loadInfo) {

		loadSheetService.saveLoad(loadInfo);
		return loadInfo;

	}

	
}
