package org.example.hotelapp.controller;

import org.example.hotelapp.services.BookingService;
import org.example.hotelapp.view.BookingRequest;
import org.example.hotelapp.view.BookingView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
  private final BookingService bookingService;

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @PostMapping
  public ResponseEntity<BookingView> bookHotel(@RequestBody BookingRequest bookingRequest) {
    BookingView bookingView = bookingService.book("user1", bookingRequest.hotelId(), bookingRequest.roomCount());
    return ResponseEntity.ok(bookingView);
  }
}
