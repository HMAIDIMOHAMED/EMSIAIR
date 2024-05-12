package com.emsiair.emsiaiirmarrakech.Service;

import com.emsiair.emsiaiirmarrakech.Model.Hotel;
import com.emsiair.emsiaiirmarrakech.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hôtel non trouvé avec l'ID : " + hotelId));
    }
    public List<Hotel> getHotelsByDestination(String destination) {
        return hotelRepository.findByDestination(destination);
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getHotelsByTarifs(double tarifs) {
        return hotelRepository.findByTarifs(tarifs);
    }

    public Hotel updateHotel(Long hotelId, Hotel hotelDetails) {
        Hotel existingHotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hôtel non trouvé avec l'ID : " + hotelId));

        existingHotel.setNom(hotelDetails.getNom());
        existingHotel.setDestination(hotelDetails.getDestination());
        existingHotel.setServicesOfferts(hotelDetails.getServicesOfferts());
        existingHotel.setTarifs(hotelDetails.getTarifs());

        return hotelRepository.save(existingHotel);
    }

    public void deleteHotel(Long hotelId) {
        Hotel existingHotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hôtel non trouvé avec l'ID : " + hotelId));

        hotelRepository.delete(existingHotel);
    }
}