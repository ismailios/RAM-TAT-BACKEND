package ma.itroad.ram.tat.tatBusiness.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.LoadSheet;
import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.loadSheet.LoadSheetDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.LoadSheetMapper;
import ma.itroad.ram.tat.tatBusiness.service.repository.LoadSheetRepository;

@Service
public class LoadSheetService {

	@Autowired
	LoadSheetRepository loadSheetRepository;
	
	@Autowired
	LoadSheetMapper loadSheetMapper;
	
	

	public List<LoadSheetDto> saveLoad(List<LoadSheetDto> LoadSheets) {
		
		LoadSheets.forEach(l->{
			System.out.println("start convert to entity");
			LoadSheet loadSheet   = loadSheetMapper.toEntity(l);
			System.out.println("start save entity");
			loadSheetRepository.save(loadSheet);
			System.out.println(" save entity ok");
			
		});
	

		return LoadSheets;
	}
	
	public LoadSheet findOneVol(String date, String volno, String immat) {

		LoadSheet loadSheet = loadSheetRepository.findOneVol(date,volno ,immat);

		return loadSheet;

	}

	
}
