package org.example.hotelapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {
  @Id
  private final String bookingId;
  private final String userId;
  private final String hotelId;
  private final Integer rooms;

  public Booking(String bookingId, String userId, String hotelId, Integer rooms) {
    this.bookingId = bookingId;
    this.userId = userId;
    this.hotelId = hotelId;
    this.rooms = rooms;
  }
}
