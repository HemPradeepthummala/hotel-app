package org.example.hotelapp.exception;

public class UserNotFoundException extends Throwable {
  public UserNotFoundException(String message) {
    super(message);
  }
}
