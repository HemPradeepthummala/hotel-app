package org.example.hotelapp.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component

public class Hotels {
	private final ArrayList<Hotel> hotels;

	public Hotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}
}
