package org.example.hotelapp.repository;

import org.example.hotelapp.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {
  List<Hotel> findHotelByCity(String city);
}
