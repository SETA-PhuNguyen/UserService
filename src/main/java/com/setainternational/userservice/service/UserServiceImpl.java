package com.setainternational.userservice.service;

import com.setainternational.userservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
  private final Keycloak keycloak;

  @Value("${keycloak.realm}")
  private String realm;

  @Override
  public UserDto updateUser(UserDto userDto) {
      UserRepresentation user =
              keycloak.realm(realm).users().get(userDto.getId()).toRepresentation();
      log.info("");
      user.setFirstName(userDto.getFirstName());
      user.setLastName(userDto.getLastName());
      user.setEmail(userDto.getEmail());

      keycloak.realm(realm).users().get(userDto.getId()).update(user);
      log.info("");
    return userDto;
  }
}
