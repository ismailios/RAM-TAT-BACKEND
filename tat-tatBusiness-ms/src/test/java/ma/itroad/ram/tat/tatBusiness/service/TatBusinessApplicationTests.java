package ma.itroad.ram.tat.tatBusiness.service;

import ma.itroad.ram.tat.tatBusiness.service.service.PredictionService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TatBusinessApplicationTests {

	@Test
	void contextLoads() {
	}



//	@Test
//	public void testSeasonOfMonth() {
//		PredictionService predictionService= new PredictionService();
//		assertEquals("WINTER", predictionService.seasonOfMonth(11));
//	}
//
//	@Test
//	public void testTimeOfDay(){
//		PredictionService predictionService= new PredictionService();
//		assertEquals(2, predictionService.timeOfDay(LocalDateTime.now()));
//
//	}


}
