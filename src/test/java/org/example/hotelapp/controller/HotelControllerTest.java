package org.example.hotelapp.controller;

import org.example.hotelapp.exception.CityNotFoundException;
import org.example.hotelapp.service.SearchServices;
import org.example.hotelapp.view.HotelView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureRestTestClient
class HotelControllerTest {
    @Autowired
    private RestTestClient restTestClient;

    @MockitoBean
    private SearchServices searchServices;

    @Test
   void shouldReturnHotelsData() throws CityNotFoundException {
      HotelView expected = new HotelView("1", "dfd", 5, "hyd");
      Mockito.when(searchServices.searchHotel("hyd")).thenReturn(List.of(expected));

	    List<HotelView> searchResult = restTestClient.get()
          .uri(uriBuilder -> uriBuilder
                  .path("/api/search/hotels")
                  .queryParam("city","hyd")
                  .build()
          ).exchange()
          .expectStatus().isOk()
          .expectBody(new ParameterizedTypeReference<List<HotelView>>() {})
          .returnResult()
          .getResponseBody();
   }
}
