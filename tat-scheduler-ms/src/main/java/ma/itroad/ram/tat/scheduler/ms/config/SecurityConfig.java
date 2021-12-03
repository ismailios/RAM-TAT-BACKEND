package ma.itroad.ram.tat.scheduler.ms.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.security.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

import feign.Logger;
import feign.RequestInterceptor;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${feign.oauth2.username}")
	String username;
	
	@Value("${feign.oauth2.password}")
	String password;
	
	@Value("${feign.oauth2.uri}")
	String uri;
	
	@Value("${feign.oauth2.resource}")
	String resource;
	
	@Value("${feign.oauth2.client-secret}")
	String client_secret;
	
	@Value("${feign.oauth2.grant-type}")
	String grant_type;
	
	@Value("${feign.oauth2.scope}")
	String scope;

	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().oauth2ResourceServer().jwt();
	}

	@Bean
	RequestInterceptor oauth2FeignRequestInterceptor() {
		return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), resource());
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	private OAuth2ProtectedResourceDetails resource() {
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setUsername(username);
		resourceDetails.setPassword(password);
		resourceDetails.setAccessTokenUri(uri);
		resourceDetails.setClientId(resource);
		resourceDetails.setClientSecret(client_secret);
		resourceDetails.setGrantType(grant_type);
		resourceDetails.setScope(Arrays.asList(scope));

		return resourceDetails;
	}

}
