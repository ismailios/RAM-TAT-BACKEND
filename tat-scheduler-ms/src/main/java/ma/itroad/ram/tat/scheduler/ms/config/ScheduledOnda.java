package ma.itroad.ram.tat.scheduler.ms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ma.itroad.ram.tat.scheduler.ms.proxy.BusinessProxy;
import ma.itroad.ram.tat.scheduler.ms.proxy.FlightServiceGet;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.onda.RootOnda;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "sheduling.enabled", matchIfMissing = true)
public class ScheduledOnda {

	@Autowired
	FlightServiceGet flightServiceGet ;
	
	@Autowired
	BusinessProxy businessProxy;
	



	@Scheduled(fixedDelayString = "PT1M")


	void getOndainfo() {
		try {
            System.out.println("onda info started");
			RootOnda rootOnda = flightServiceGet.getOndaInfo();
			 System.out.println("get onda info ok");	
			    businessProxy.postOndaInfo(rootOnda);
			    System.out.println("post onda info ok");	
		
		
			

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
