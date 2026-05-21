package org.example.hotelapp.models;

import org.example.hotelapp.exceptions.InvalidCityName;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component

public class Hotels {
	private final ArrayList<Hotel> hotels;

	public Hotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<Hotel> getHotelsByCity(String city) throws InvalidCityName {
		if(Objects.equals(city, "") || city == null) {
			throw new InvalidCityName("Invalid City Name");
		}
		return hotels.stream().filter(hotel -> hotel.city().equals(city)).toList();
	}
}
