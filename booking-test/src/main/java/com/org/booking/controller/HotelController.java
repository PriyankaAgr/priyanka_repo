package com.org.booking.controller;

import com.org.booking.model.Hotel;
import com.org.booking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
        Optional<Hotel> res = hotelService.getById(id);
        return res.map(hotel-> ResponseEntity.ok().body(hotel)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-city")
    public List<Hotel> getHotelByName(@RequestParam String city){
        return hotelService.getByName(city);
    }
}
