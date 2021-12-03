package ma.itroad.ram.tat.tatBusiness.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableSwagger2
@EnableFeignClients
@EnableEurekaClient

public class TatBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(TatBusinessApplication.class, args);




	}
}
