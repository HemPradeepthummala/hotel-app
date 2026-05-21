package org.example.hotelapp.service;

import org.example.hotelapp.exception.InvalidCityName;
import org.example.hotelapp.model.Hotel;
import org.example.hotelapp.model.Hotels;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchServices {
    private final Hotels hotels;

    public SearchServices(Hotels hotels) {
        this.hotels = hotels;
    }

    public List<Hotel> searchHotel(String city) throws InvalidCityName {
		    return hotels.getHotelsByCity(city);
    }
}
