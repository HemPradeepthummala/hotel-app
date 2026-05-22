package org.example.hotelapp.controller;

import org.example.hotelapp.model.Booking;
import org.example.hotelapp.model.User;
import org.example.hotelapp.service.AppUserDetailsService;
import org.example.hotelapp.service.BookingService;
import org.example.hotelapp.view.BookingDetailsView;
import org.example.hotelapp.view.BookingRequest;
import org.example.hotelapp.view.BookingView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
  private final BookingService bookingService;
	private final AppUserDetailsService userDetailsService;

	public BookingController(BookingService bookingService, AppUserDetailsService userDetailsService) {
    this.bookingService = bookingService;
		this.userDetailsService = userDetailsService;
	}

  @PostMapping
  public ResponseEntity<BookingView> bookHotel(@RequestBody BookingRequest bookingRequest, Authentication user) {
    String userId = userDetailsService.getUserId(user.getName());
    BookingView bookingView = bookingService.book(userId, bookingRequest.hotelId(), bookingRequest.rooms());
    return ResponseEntity.ok(bookingView);
  }
  @GetMapping("/{bookingId}/receipt")
  public ResponseEntity<String> downloadReceipt(@PathVariable String bookingId){
    String recipt = bookingService.getRecipt(bookingId);
    return new ResponseEntity<>(recipt,HttpStatus.OK);
  }

  @GetMapping
    public ResponseEntity<List<BookingDetailsView>> listHotels(Authentication user) {
      String userId = this.userDetailsService.getUserId(user.getName());
      List<Booking> bookings = bookingService.getBookings(userId);
      List<BookingDetailsView> bookingList = bookings.stream().map(Booking::project).toList();
      return ResponseEntity.ok(bookingList);
    }
}
