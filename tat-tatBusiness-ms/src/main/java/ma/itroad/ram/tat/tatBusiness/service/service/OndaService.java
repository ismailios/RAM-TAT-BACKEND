package ma.itroad.ram.tat.tatBusiness.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.ms.service.dto.changer.onda.RootOndaDto;
import ma.itroad.ram.tat.tatBusiness.service.domain.OndaInfo;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.OndaInfoMapper;
import ma.itroad.ram.tat.tatBusiness.service.repository.OndaRepository;

@Service
public class OndaService {

	@Autowired
	OndaRepository ondaRepository;
	
	@Autowired
	OndaInfoMapper ondaInfoMapper;
	
	

	public RootOndaDto saveOndaInfo(RootOndaDto rootOndaDto) {
		System.out.println("start"+ rootOndaDto );
		rootOndaDto.getOnda().getListeVols().getVol().forEach(v->{
			System.out.println("start convert to entity");
			OndaInfo ondaInfo   = ondaInfoMapper.toEntity(v);
			System.out.println("start save entity");
			ondaRepository.save(ondaInfo);
			System.out.println(" save entity ok");
			
		});
	

		return rootOndaDto;
	}

	public OndaInfo findOneVol(String date, String immat, String volno) {

		OndaInfo ondaInfo = ondaRepository.findOneVol(date, immat, volno);

		return ondaInfo;

	}
}
