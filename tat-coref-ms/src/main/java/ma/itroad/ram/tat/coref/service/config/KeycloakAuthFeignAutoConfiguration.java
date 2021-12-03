package ma.itroad.ram.tat.coref.service.config;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConditionalOnClass({ FeignClient.class })
public class KeycloakAuthFeignAutoConfiguration {

	 @Bean
	    public RequestInterceptor keycloakAuthFeignRequestInterceptor() {
	        return new KeycloakAuthFeignRequestInterceptor();
	    }
	
}
