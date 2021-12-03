package ma.itroad.ram.tat.coref.service.config;



import feign.RequestInterceptor;
import feign.RequestTemplate;

import org.apache.logging.log4j.util.Strings;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class KeycloakAuthFeignRequestInterceptor implements RequestInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(KeycloakAuthFeignRequestInterceptor.class);

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String BEARER_TOKEN_TYPE = "Bearer";

    public KeycloakAuthFeignRequestInterceptor() {
        // Default Constructor
    }

    @Override
    public void apply(RequestTemplate template) {
        KeycloakSecurityContext context = getKeycloakSecurityContext();
        if (template.headers().containsKey(AUTHORIZATION_HEADER)) {
            LOGGER.warn("The Authorization token has been already set");
        } else if (context.getIdToken() == null && Strings.isEmpty(context.getTokenString())) {
            LOGGER.warn("Can not obtain existing token for request, if it is a non secured request, ignore.");
        } else {
            LOGGER.debug("Constructing Header {} for Token {}", AUTHORIZATION_HEADER, BEARER_TOKEN_TYPE);
            template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, context.getTokenString()));
        }
    }

    @SuppressWarnings("unchecked")
	protected KeycloakSecurityContext getKeycloakSecurityContext() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext == null) {
            throw new IllegalStateException("Cannot get security Context");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("Authentication could not be null");
        }
        KeycloakPrincipal<KeycloakSecurityContext> keycloakPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (keycloakPrincipal == null) {
            throw new IllegalStateException("Cannot set authorization header because there is no authenticated principal");
        }
        return keycloakPrincipal.getKeycloakSecurityContext();
    }
	
}
