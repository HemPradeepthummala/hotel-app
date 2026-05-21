package org.example.hotelapp.controller;

import org.example.hotelapp.model.Booking;
import org.example.hotelapp.service.BookingService;
import org.example.hotelapp.view.BookingRequest;
import org.example.hotelapp.view.BookingView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
  private final BookingService bookingService;

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @PostMapping
  public ResponseEntity<BookingView> bookHotel(@RequestBody BookingRequest bookingRequest) {
    BookingView bookingView = bookingService.book("user1", bookingRequest.hotelId(), bookingRequest.rooms());
    return ResponseEntity.ok(bookingView);
  }
  @GetMapping("/{bookingId}/receipt")
  public ResponseEntity<String> downloadReceipt(@PathVariable String bookingId){
    String recipt = bookingService.getRecipt(bookingId);
    return new ResponseEntity<>(recipt,HttpStatus.OK);
  }
}
