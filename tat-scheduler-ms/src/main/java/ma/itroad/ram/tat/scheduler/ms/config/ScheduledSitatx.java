package ma.itroad.ram.tat.scheduler.ms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ma.itroad.ram.tat.scheduler.ms.proxy.BusinessProxy;
import ma.itroad.ram.tat.scheduler.ms.proxy.FlightServiceGet;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.sitatx.RootSitatx;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "sheduling.enabled", matchIfMissing = true)
public class ScheduledSitatx {

	@Autowired
	FlightServiceGet flightServiceGet;

	@Autowired
	BusinessProxy businessProxy;

	@Scheduled(fixedDelayString = "PT1M")

	void getSitatxMessage() {
		try {
			System.out.println("sitatx started");
			RootSitatx sitatx = flightServiceGet.getSitatxMessage();
			System.out.println("get sitatx info ok");
			businessProxy.postSitatxMessage(sitatx);
			System.out.println("post sitatx info ok");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
