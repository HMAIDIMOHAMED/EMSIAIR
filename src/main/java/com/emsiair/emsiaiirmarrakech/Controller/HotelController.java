package com.emsiair.emsiaiirmarrakech.Controller;

import com.emsiair.emsiaiirmarrakech.Model.Hotel;
import com.emsiair.emsiaiirmarrakech.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{hotelId}")
    public Hotel getHotelById(@PathVariable Long hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/{hotelId}")
    public Hotel updateHotel(@PathVariable Long hotelId, @RequestBody Hotel hotelDetails) {
        return hotelService.updateHotel(hotelId, hotelDetails);
    }

    @DeleteMapping("/{hotelId}")
    public void deleteHotel(@PathVariable Long hotelId) {
        hotelService.deleteHotel(hotelId);
    }
    @GetMapping("/by-destination")
    public ResponseEntity<List<Hotel>> getHotelsByDestination(@RequestParam String destination) {
        List<Hotel> hotels = hotelService.getHotelsByDestination(destination);
        return ResponseEntity.ok().body(hotels);
    }
    @GetMapping("/hotels/by-tarif")
    public ResponseEntity<List<Hotel>> getHotelsByTarif(@RequestParam Double tarifs) {
        List<Hotel> hotels = hotelService.getHotelsByTarifs(tarifs);
        return ResponseEntity.ok().body(hotels);
    }
}
