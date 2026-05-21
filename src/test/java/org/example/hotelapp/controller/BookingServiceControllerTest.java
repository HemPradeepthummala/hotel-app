package org.example.hotelapp.controller;

import org.example.hotelapp.services.BookingService;
import org.example.hotelapp.view.BookingRequest;
import org.example.hotelapp.view.BookingView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureRestTestClient
class BookingServiceControllerTest {
  @Autowired
  private RestTestClient client;

  @MockitoBean
  private BookingService bookingService;

  @Test
  void shouldBookHotel() {
    BookingView expectedBookingView = new BookingView("booking1");
    when(bookingService.book("user1", "hotel1", 2)).thenReturn(expectedBookingView);

    BookingView responseBody = client.post()
        .uri("/api/booking")
        .body(new BookingRequest("hotel1", 2))
        .exchange()
        .expectStatus().isOk()
        .expectBody(BookingView.class)
        .returnResult()
        .getResponseBody();

    assertEquals(expectedBookingView, responseBody);
  }
}