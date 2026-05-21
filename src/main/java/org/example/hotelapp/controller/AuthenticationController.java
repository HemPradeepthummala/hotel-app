package org.example.hotelapp.controller;

import org.example.hotelapp.repository.UserRepository;
import org.example.hotelapp.view.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AuthenticationController {
  private final UserRepository userRepository;

  public AuthenticationController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("/login")
  public void login(@RequestBody LoginRequest loginRequest) {
     ResponseEntity.ok();
  }
}
