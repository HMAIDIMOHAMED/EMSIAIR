package com.emsiair.emsiaiirmarrakech;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.emsiair.emsiaiirmarrakech.Model.Hotel;
import com.emsiair.emsiaiirmarrakech.Repository.HotelRepository;
import com.emsiair.emsiaiirmarrakech.Service.HotelService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class HotelServiceTest {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelService hotelService;

    @Test
    public void testGetAllHotels() {
        Hotel hotel1 = new Hotel("Hotel A", "Paris", "WiFi, Petit déjeuner", 100.0);
        Hotel hotel2 = new Hotel("Hotel B", "New York", "Piscine, Restaurant", 200.0);
        List<Hotel> hotels = Arrays.asList(hotel1, hotel2);

        when(hotelRepository.findAll()).thenReturn(hotels);

        List<Hotel> result = hotelService.getAllHotels();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Hotel A", result.get(0).getNom());
        assertEquals("Paris", result.get(0).getDestination());

        verify(hotelRepository, times(1)).findAll();
    }

    @Test
    public void testGetHotelById() {
        Hotel hotel = new Hotel("Hotel A", "Paris", "WiFi, Petit déjeuner", 100.0);
        hotel.setId(1L);

        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));

        Hotel result = hotelService.getHotelById(1L);

        assertNotNull(result);
        assertEquals("Hotel A", result.getNom());
        assertEquals("Paris", result.getDestination());

        verify(hotelRepository, times(1)).findById(1L);
    }
    @Test
    public void testGetHotelsByDestination() {
        String destination = "Paris";
        Hotel hotel1 = new Hotel("Hotel A", "Paris", "WiFi, Petit déjeuner", 100.0);
        Hotel hotel2 = new Hotel("Hotel B", "Paris", "Piscine, Restaurant", 200.0);
        List<Hotel> hotels = Arrays.asList(hotel1, hotel2);

        when(hotelRepository.findByDestination(destination)).thenReturn(hotels);

        List<Hotel> result = hotelService.getHotelsByDestination(destination);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Hotel A", result.get(0).getNom());
        assertEquals("Paris", result.get(0).getDestination());

        verify(hotelRepository, times(1)).findByDestination(destination);
    }
    @Test
    public void testAddHotel() {
        Hotel hotelToAdd = new Hotel("Hotel C", "London", "Spa, Gym", 150.0);
        when(hotelRepository.save(any(Hotel.class))).thenReturn(hotelToAdd);

        Hotel result = hotelService.addHotel(hotelToAdd);

        assertNotNull(result);
        assertEquals("Hotel C", result.getNom());
        assertEquals("London", result.getDestination());

        verify(hotelRepository, times(1)).save(any(Hotel.class));
    }
    @Test
    public void testUpdateHotel() {
        Hotel existingHotel = new Hotel("Hotel D", "Berlin", "Sauna, Bar", 180.0);
        existingHotel.setId(1L);

        Hotel updatedHotelDetails = new Hotel("Hotel E", "Berlin", "Sauna, Bar, Restaurant", 200.0);

        when(hotelRepository.findById(1L)).thenReturn(Optional.of(existingHotel));
        when(hotelRepository.save(any(Hotel.class))).thenReturn(updatedHotelDetails);

        Hotel result = hotelService.updateHotel(1L, updatedHotelDetails);

        assertNotNull(result);
        assertEquals("Hotel E", result.getNom());
        assertEquals("Berlin", result.getDestination());

        verify(hotelRepository, times(1)).findById(1L);
        verify(hotelRepository, times(1)).save(any(Hotel.class));
    }

}
