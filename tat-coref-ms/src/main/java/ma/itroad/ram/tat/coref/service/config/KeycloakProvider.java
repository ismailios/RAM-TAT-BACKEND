package ma.itroad.ram.tat.coref.service.config;

import java.util.Map;
import java.util.Set;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class KeycloakProvider {

	@Value("${keycloak.resource}")
	private String resource;

	@Value("${keycloak.realm}")
	private String realm;

	@Value("${keycloak.credentials.secret}")
	private String secret;

	@SuppressWarnings("unchecked")
	public String getConnectedUser() {
		KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		return kp.getKeycloakSecurityContext().getToken().getPreferredUsername();
	}

	@SuppressWarnings("unchecked")
	public Set<String> getProfile() {
		KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		return kp.getKeycloakSecurityContext().getToken().getRealmAccess().getRoles();
	}

	@SuppressWarnings("unchecked")
	public String getClaimValue(String key) {
		KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		AccessToken token = kp.getKeycloakSecurityContext().getToken();
		Map<String, Object> otherClaims = token.getOtherClaims();
		return otherClaims.get(key) != null ? (String) otherClaims.get(key) : null;
	}
}