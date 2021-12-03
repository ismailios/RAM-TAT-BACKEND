package ma.itroad.ram.tat.tatBusiness.service.service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.FlightSitatx;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.dtos.AirPortDto;
import ma.itroad.ram.tat.tatBusiness.service.proxy.CorefProxy;

@Service
public class TatSitatxAssignement {

	@Autowired
	SitatxService sitatxService;
	
	@Autowired
	CorefProxy corefProxy;

	public void sitatxAssignement(Tat tat) {

		tat.getFlights().forEach(f -> {

			
			try {
				DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyMMdd");
				String date = f.getDayOfOriginAsDate().format(formatters);
				String departure = f.getDepApActual();
				String volno = f.getFnNumber();
				System.out.println(date);
				
				String airPort  = corefProxy.getAirportByName(departure).get().getShortName();



				FlightSitatx flightSitatx = sitatxService.findOneVol(date, airPort, volno);
				tat.setFlightSitatx(flightSitatx);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

	}

}
