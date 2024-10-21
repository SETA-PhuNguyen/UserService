package com.setainternational.userservice.controller;

import com.setainternational.userservice.dto.UserDto;
import com.setainternational.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @PutMapping
  public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
    userService.updateUser(userDto);
    return ResponseEntity.ok().body(userDto);
  }
}
