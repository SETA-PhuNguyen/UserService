package com.setainternational.userservice.config;

import com.setainternational.userservice.properties.ClientCredentialProperties;
import com.setainternational.userservice.properties.KeycloakProperties;
import lombok.RequiredArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class KeycloakConfig {
  private final KeycloakProperties keycloakProperties;
  private final ClientCredentialProperties credentialProperties;

  /**
   * Get keycloak instance
   *
   * @return Keycloak instance
   */
  @Bean
  public Keycloak getKeycloak() {
    return KeycloakBuilder.builder()
        .serverUrl(keycloakProperties.getServerUrl())
        .realm(keycloakProperties.getRealm())
        .clientId(keycloakProperties.getClientId())
        .username(credentialProperties.getUserName())
        .password(credentialProperties.getPassword())
        .grantType(OAuth2Constants.PASSWORD)
        .build();
  }
}
