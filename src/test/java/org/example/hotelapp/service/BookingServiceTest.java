package org.example.hotelapp.service;

import org.example.hotelapp.model.Booking;
import org.example.hotelapp.repository.BookingRepository;
import org.example.hotelapp.repository.UserRepository;
import org.example.hotelapp.view.BookingView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

  @Test
  void bookHotel() {
    BookingRepository bookingRepository = Mockito.mock(BookingRepository.class);
    BookingView expectedBookingView = new BookingView("id");
    UserRepository userRepository = Mockito.mock(UserRepository.class);

    BookingService bookingService = new BookingService(bookingRepository, () -> "id", userRepository);
    BookingView actualBookingView = bookingService.book("user1", "hotel1", 2);

    assertEquals(expectedBookingView, actualBookingView);
  }
}