package org.example.hotelapp.services;

import org.example.hotelapp.models.Booking;
import org.example.hotelapp.view.BookingView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookingService {
  private final ArrayList<Booking> bookings;
  private final IdGenerator idGenerator;

  public BookingService(ArrayList<Booking> bookings, IdGenerator idGenerator) {
    this.bookings = bookings;
    this.idGenerator = idGenerator;
  }

  public BookingView book(String userId, String hotelId, Integer roomCount) {
    String bookingId = idGenerator.generate();
    Booking booking = new Booking(bookingId, userId, hotelId, roomCount);

    bookings.add(booking);

    return new BookingView(bookingId);
  }
}
