package com.org.booking.util;


import com.org.booking.model.Hotel;

public class TestUtils {

    public static Hotel createHotel(Long id, String name, String city, int rating) {
        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotel.setName(name);
        hotel.setCity(city);
        hotel.setRating(rating);
        return hotel;
    }
}
