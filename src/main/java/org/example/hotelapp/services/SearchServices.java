package org.example.hotelapp.services;

import org.example.hotelapp.models.Hotel;
import org.example.hotelapp.models.Hotels;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchServices {
    private final Hotels hotels;

    public SearchServices(Hotels hotels) {
        this.hotels = hotels;
    }

    public List<Hotel> searchHotel(String city){
        return List.of(new Hotel("1","dfd",5,"hyd"));
    }
}
