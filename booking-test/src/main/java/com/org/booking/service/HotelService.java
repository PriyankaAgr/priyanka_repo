package com.org.booking.service;

import com.org.booking.model.Hotel;
import com.org.booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return (List<Hotel>) hotelRepository.findAll();
    }

    public Optional<Hotel> getById(Long Id){
        return hotelRepository.findById(Id);
    }

    public List<Hotel> getByName(String city){
        return hotelRepository.findHotelByCity(city);
    }
}
