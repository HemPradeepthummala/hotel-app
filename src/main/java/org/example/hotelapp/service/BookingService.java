package org.example.hotelapp.service;

import org.example.hotelapp.model.Booking;
import org.example.hotelapp.repository.BookingRepository;
import org.example.hotelapp.view.BookingView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {
  private final BookingRepository bookings;
  private final IdGenerator idGenerator;

  public BookingService(BookingRepository bookingRepository, IdGenerator idGenerator) {
    this.bookings = bookingRepository;
    this.idGenerator = idGenerator;
  }

  @Transactional
  public BookingView book(String userId, String hotelId, Integer rooms) {
    String bookingId = idGenerator.generate();
    Booking booking = new Booking(bookingId, userId, hotelId, rooms);

    this.bookings.save(booking);

    return new BookingView(bookingId);
  }

    public String getRecipt(String bookingId) {
      Booking bookingInfo = bookings.getBookingsByBookingId(bookingId);
      System.out.println("bookings  :: " + bookingInfo.generateReceipt());
      return bookingInfo.generateReceipt();
    }
}
