package com.emsiair.emsiaiirmarrakech.Repository;

import com.emsiair.emsiaiirmarrakech.Model.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    List<Voyage> findByDestination(String destination);
    List<Voyage> findByDateDepartAfter(Date date);
    List<Voyage> findByPrixLessThanEqual(double prix);
    List<Voyage> findByDestinationAndDateDepartAndPrixBetween(String destination, Date dateDepart, double prixMin, double prixMax);
}