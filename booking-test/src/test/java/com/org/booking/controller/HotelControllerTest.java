package com.org.booking.controller;

import com.org.booking.model.Hotel;
import com.org.booking.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HotelService hotelService;

    @InjectMocks
    private HotelController hotelController;

    @BeforeEach
    void setup() {
        when(hotelService.getAllHotels()).thenReturn(
                Arrays.asList(
                        new Hotel(1L, "Grand Plaza", "New York", 5),
                        new Hotel(2L, "Sea Breeze", "Miami", 4)
                )
        );
    }

    @Test
    void shouldReturnAllHotels() throws Exception {
        mockMvc.perform(get("/hotel"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Grand Plaza"))
                .andExpect(jsonPath("$[1].name").value("Sea Breeze"));
    }
}

