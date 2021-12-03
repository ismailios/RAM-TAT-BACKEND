package ma.itroad.ram.tat.thirdPartyConnectors.service.config;

import java.util.List;

import org.keycloak.adapters.springboot.KeycloakBaseSpringBootConfiguration;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.filter.KeycloakAuthenticationProcessingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;

@KeycloakConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
@EnableAutoConfiguration(exclude = { UserDetailsServiceAutoConfiguration.class })
public class KeycloakSecurityConfiguration extends KeycloakWebSecurityConfigurerAdapter {

	@Value("${keycloak-add-on.unprotectedpaths}")
	private List<String> unprotectedPaths;

	@Configuration
	static class CustomKeycloakBaseSpringBootConfiguration extends KeycloakBaseSpringBootConfiguration {
	}

	/**
	 * Defines the session authentication strategy.
	 */
	@Bean
	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		// required for bearer-only applications.
		return new NullAuthenticatedSessionStrategy();
	}

	/**
	 * Prevent double bean declaration
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean keycloakAuthenticationProcessingFilterRegistrationBean(KeycloakAuthenticationProcessingFilter filter) {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
		registrationBean.setEnabled(false);
		return registrationBean;
	}

	/**
	 * Registers the KeycloakAuthenticationProvider with the authentication manager.
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) {
		KeycloakAuthenticationProvider keycloakAuthenticationProvider = new KeycloakAuthenticationProvider();
		// simple Authority Mapper to avoid ROLE_
		keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
		auth.authenticationProvider(keycloakAuthenticationProvider);
	}

	/**
	 * Spring security specific configuration
	 * 
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		// add cors options
		http.cors().and().csrf().disable();
		http.headers()
				.contentSecurityPolicy("default-src 'self';connect-src 'self' ;frame-src 'self' data:; script-src 'self' ; style-src 'self' ; img-src 'self' data:; font-src 'self' data:")
				.and()
				.referrerPolicy(ReferrerPolicyHeaderWriter.ReferrerPolicy.STRICT_ORIGIN_WHEN_CROSS_ORIGIN)
				.and()
				.featurePolicy("geolocation 'none'; midi 'none'; sync-xhr 'none'; microphone 'none'; camera 'none'; magnetometer 'none'; gyroscope 'none'; speaker 'none'; fullscreen 'self'; payment 'none'")
				.and()
				.frameOptions()
				.deny();
		http.authorizeRequests().antMatchers("/**").authenticated()
				.antMatchers(HttpMethod.TRACE).denyAll()
				.antMatchers(HttpMethod.PATCH).denyAll()
				.antMatchers(HttpMethod.HEAD).denyAll()
				.anyRequest().authenticated();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		if (!unprotectedPaths.isEmpty()) {
			web.ignoring().antMatchers(unprotectedPaths.toArray(new String[unprotectedPaths.size()]));
		}
		// No security restriction for static resources : swagger ui & spring fox
		configureStaticResourcesAccessControlRules(web);
	}

	private void configureStaticResourcesAccessControlRules(WebSecurity web) {
		web.ignoring().antMatchers("/v2/api-docs/**");
		web.ignoring().antMatchers("/swagger-resources/**");
		web.ignoring().antMatchers("/swagger-ui.html");
		web.ignoring().antMatchers("/webjars/**/*");
		web.ignoring().antMatchers("/swagger-resources/webjars/**");
	}

}