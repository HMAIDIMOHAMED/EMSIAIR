package com.emsiair.emsiaiirmarrakech.Repository;

import com.emsiair.emsiaiirmarrakech.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByDestination(String destination);
    List<Hotel> findByTarifs(double tarifs);


}