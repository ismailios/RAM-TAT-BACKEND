package ma.itroad.ram.tat.scheduler.ms.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ma.itroad.ram.tat.scheduler.ms.dto.LoadSheet;
import ma.itroad.ram.tat.scheduler.ms.proxy.BusinessProxy;
import ma.itroad.ram.tat.scheduler.ms.proxy.FlightServiceGet;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.onda.RootOnda;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "sheduling.enabled", matchIfMissing = true)
public class ScheduledLoadSheet {

	@Autowired
	FlightServiceGet flightServiceGet ;
	
	@Autowired
	BusinessProxy businessProxy;
	
	

	@Scheduled(fixedDelayString = "PT1M")


	void getLoadSheet() {
		try {
          
			List<LoadSheet> Loadsheets = flightServiceGet.getLoadSheet();

			    businessProxy.postLoadSheet(Loadsheets);
			  
		
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
}
