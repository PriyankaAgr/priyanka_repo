package com.org.booking.service;

import com.org.booking.model.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
        import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HotelServiceTest {

    @Mock
    private HotelService hotelService;

    @BeforeEach
    void setup() {
        hotelService = mock(HotelService.class);
    }

    @Test
    public void testGetAllHotels() {
        List<Hotel> hotels = Arrays.asList(
                new Hotel(1L, "Grand Plaza", "New York", 5),
                new Hotel(2L, "Sea Breeze", "Miami", 4)
        );

        when(hotelService.getAllHotels()).thenReturn(hotels);

        List<Hotel> result = hotelService.getAllHotels();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(hotelService, times(1)).getAllHotels();
    }
}

