package org.example.hotelapp.controller;

import org.example.hotelapp.service.AppUserDetailsService;
import org.example.hotelapp.service.JwtService;
import org.example.hotelapp.view.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AuthenticationController {

  private final AppUserDetailsService appUserDetailsService;

  public AuthenticationController(AppUserDetailsService appUserDetailsService) {
    this.appUserDetailsService = appUserDetailsService;
  }

  @PostMapping("/register")
  public ResponseEntity<String> login(@RequestBody SignUpRequest signUpRequest) {
    String userId = appUserDetailsService.registerUser(signUpRequest);
    return ResponseEntity.ok(userId);
  }
}
