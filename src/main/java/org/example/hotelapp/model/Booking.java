package org.example.hotelapp.model;

public record Booking(String bookingId, String userId, String hotelId, Integer roomCount) {
}
