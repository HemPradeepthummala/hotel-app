package org.example.hotelapp.controller;

import org.example.hotelapp.exception.InvalidCityName;
import org.example.hotelapp.model.Hotel;
import org.example.hotelapp.service.SearchServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
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
   void shouldReturnHotelsData(){
        Hotel mockHotel = new Hotel("1", "dfd", 5, "hyd");
	    try {
		    Mockito.when(searchServices.searchHotel("hyd")).thenReturn(List.of(mockHotel));
	    } catch (InvalidCityName e) {
		    throw new RuntimeException(e);
	    }

	    RestTestClient.BodyContentSpec searchResult = restTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/search/hotels")
                        .queryParam("city","hyd")
                        .build()
                ).exchange().expectStatus().isOk().expectBody().jsonPath("$[0].id").isEqualTo("1")
               .jsonPath("$[0].name").isEqualTo("dfd")
               .jsonPath("$[0].city").isEqualTo("hyd");
   }
}
