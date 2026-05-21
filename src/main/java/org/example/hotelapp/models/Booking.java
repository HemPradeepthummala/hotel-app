package org.example.hotelapp.models;

public record Booking(String bookingId, String userId, String hotelId, Integer roomCount) {
}
