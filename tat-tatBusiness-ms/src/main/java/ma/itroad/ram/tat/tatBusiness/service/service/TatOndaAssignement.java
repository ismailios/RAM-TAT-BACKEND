package ma.itroad.ram.tat.tatBusiness.service.service;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.OndaInfo;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;


@Service
public class TatOndaAssignement {

@Autowired
OndaService ondaService;
	
	public void ondaAssignment(Tat tat) {
		
		
		tat.getFlights().forEach(f-> {
			
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			String date = f.getDayOfOriginAsDate().format(formatters);
			String immat= f.getAcRegistration();
			String volno = f.getFlightNumber();
			
			System.out.println(date);
			System.out.println(date);
			
			OndaInfo ondaInfo = ondaService.findOneVol(date, immat, volno);
			tat.setOndainfo(ondaInfo);
			
			
		});
		
		
	}
	
}
