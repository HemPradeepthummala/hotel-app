package org.example.hotelapp.controllers;

import org.example.hotelapp.exceptions.InvalidCityName;
import org.example.hotelapp.models.Hotel;
import org.example.hotelapp.services.SearchServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {
    private final SearchServices searchServices;

    public HotelController(SearchServices searchServices) {
        this.searchServices = searchServices;
    }

    @GetMapping("/api/search/hotels")
    public ResponseEntity<List<Hotel>> search(@RequestParam String city){
	    try {
		    return ResponseEntity.ok(searchServices.searchHotel(city));
	    } catch (InvalidCityName e) {
		    return ResponseEntity.badRequest().build();
	    }
    }

}
