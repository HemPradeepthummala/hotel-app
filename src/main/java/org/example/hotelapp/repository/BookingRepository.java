package org.example.hotelapp.repository;

import org.example.hotelapp.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    Booking getBookingsByBookingId(String bookingId);
}

