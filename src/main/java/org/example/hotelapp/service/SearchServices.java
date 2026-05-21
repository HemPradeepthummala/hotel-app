package org.example.hotelapp.service;

import org.example.hotelapp.exception.CityNotFoundException;
import org.example.hotelapp.model.Hotel;
import org.example.hotelapp.repository.HotelRepository;
import org.example.hotelapp.view.HotelView;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchServices {
    private final HotelRepository hotels;

    public SearchServices(HotelRepository hotelRepository) {
        this.hotels = hotelRepository;
    }

    public List<HotelView> searchHotel(String city) throws CityNotFoundException {
        if (city.isEmpty()) {
            throw new CityNotFoundException("empty city name");
        }
        List<Hotel> hotelByCity = hotels.findHotelByCity(city);
        return hotelByCity.stream().map(Hotel::project).toList();
    }
}
