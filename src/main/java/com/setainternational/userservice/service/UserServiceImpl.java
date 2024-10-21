package com.setainternational.userservice.service;

import com.setainternational.userservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final Keycloak keycloak;

  @Value("${keycloak.realm}")
  private String realm;

  @Override
  public UserDto updateUser(UserDto userDto) {
    UserRepresentation user =
        keycloak.realm(realm).users().get(userDto.getId()).toRepresentation();

    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setEmail(userDto.getEmail());

    keycloak.realm(realm).users().get(userDto.getId()).update(user);
    return userDto;
  }
}
