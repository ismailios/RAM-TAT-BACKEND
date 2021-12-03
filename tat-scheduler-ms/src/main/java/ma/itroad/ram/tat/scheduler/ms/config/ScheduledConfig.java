package ma.itroad.ram.tat.scheduler.ms.config;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ma.itroad.ram.tat.scheduler.ms.domain.NetlineInstantTransaction;
import ma.itroad.ram.tat.scheduler.ms.proxy.FlightServiceGet;
import ma.itroad.ram.tat.scheduler.ms.proxy.FlightServicePost;
import ma.itroad.ram.tat.scheduler.ms.service.FlightService;
import ma.itroad.ram.tat.scheduler.ms.service.NetlineInstantTransactionService;
import ma.itroad.ram.tat.scheduler.ms.service.dto.NetlineFlightMessageDto;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.ChangerRootDto;
import ma.itroad.ram.tat.scheduler.ms.service.dto.changer.InstantTransactionDto;
import ma.itroad.ram.tat.scheduler.ms.service.mapper.InstantTransactionMapper;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "sheduling.enabled", matchIfMissing = true)
public class ScheduledConfig {
	
	private final Logger log = LoggerFactory.getLogger(ScheduledConfig.class);
	
	@Autowired
	FlightServiceGet flightServiceGet;
	@Autowired
	FlightServicePost flightServicePost;
	@Autowired
	FlightService flightService;

	@Autowired
	NetlineInstantTransactionService netlineInstantTransactionService;
	@Autowired
	InstantTransactionMapper instantTransactionMapper;

	/*
	 * @Autowired NetlineFightChangeService netlineFightChangeService;
	 */

	@Scheduled(fixedDelayString = "${scheduler.get_flights_time}")
	void someJob() throws InterruptedException {
		try {
			System.out.println("started_getting_flights " + LocalDateTime.now());
			List<NetlineFlightMessageDto> netlineFlightMessages = flightServiceGet.getAllFlights();
			System.out.println("get flights ok " + LocalDateTime.now());
			try {
				System.out.println("started_posting_flights " + LocalDateTime.now());
				log.info("started_posting_flights " + LocalDateTime.now());
				flightServicePost.postAllFlights(netlineFlightMessages);
				System.out.println("post flights ok " + LocalDateTime.now());

			} catch (Exception e) {

				System.out.println(e.getMessage());
				for (int i = 0; i < netlineFlightMessages.size() - 1; i++) {
					flightService.save(netlineFlightMessages.get(i));

				}
				System.out.println("post flights didn't work" + LocalDateTime.now());
				System.out.println(" Exception message : " + e);
			}
		} catch (Exception e) {
			System.out.println("get flights FROM INTERFACE didn't work " + LocalDateTime.now() + "\n" + ", exception: "
					+ e.toString());

		}

	}


	// new scheduled job by elaidi
	@Scheduled(fixedDelayString = "${scheduler.get_changes_time}")


	void newJobChanges() throws InterruptedException {
		try {
			System.out.println("started_getting_changes " + LocalDateTime.now());
			ChangerRootDto dto = flightServiceGet.getChangeTransactions();
			if (dto != null)
				System.out.println("get changes ok " + LocalDateTime.now());
			try {
				flightServicePost.postTransactionChange(dto);
				System.out.println("post changes ok " + LocalDateTime.now());
			} catch (Exception e) {

				System.out.println("POST Changes to Business didn't work " + LocalDateTime.now());
				System.out.println("exception: " + e);
				System.out.println(e.getMessage());
				for (InstantTransactionDto transactionDto : dto.getNetlineInstantChangerDto().getTransactions()) {
					NetlineInstantTransaction transaction = instantTransactionMapper.toEntity(transactionDto);
					netlineInstantTransactionService.saveTransaction(transaction);
				}
			}
		} catch (Exception e) {
			System.out.println("get Changes FROM INTERFACE didn't work " + LocalDateTime.now() + "\n" + ", exception: "
					+ e.toString());
		}

	}

}
