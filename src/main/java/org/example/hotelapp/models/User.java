package org.example.hotelapp.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
  private final String username;
  private final String password;

  public User(String username, String Password) {
    this.username = username;
    this.password = Password;
  }
}
