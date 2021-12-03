package ma.itroad.ram.tat.tatBusiness.service.service;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.LoadSheet;
import ma.itroad.ram.tat.tatBusiness.service.domain.OndaInfo;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;

@Service
public class TatLoadAssignement {

	@Autowired
	LoadSheetService loadSheetService;
	
	public void loadAssignement(Tat tat) {
		
tat.getFlights().forEach(f-> {
			
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("uuuuMMdd");
			String date = f.getDayOfOriginAsDate().format(formatters);
			
			String immat= f.getDepApActual();
			
			String volno = f.getFlightNumber();
			
			System.out.println(date);
			System.out.println(date);
			
			LoadSheet loadSheet = loadSheetService.findOneVol(date, volno, immat);
			tat.setLoadSheet(loadSheet);
			
			
		});
		
		
	}
}
