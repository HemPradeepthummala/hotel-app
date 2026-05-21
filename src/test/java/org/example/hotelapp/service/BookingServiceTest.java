package org.example.hotelapp.service;

import org.example.hotelapp.model.Booking;
import org.example.hotelapp.view.BookingView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

  @Test
  void bookHotel() {
    BookingView expectedBookingView = new BookingView("id");

    BookingService bookingService = new BookingService(new ArrayList<Booking>(), () -> "id");
    BookingView actualBookingView = bookingService.book("user1", "hotel1", 2);

    assertEquals(expectedBookingView, actualBookingView);
  }
}