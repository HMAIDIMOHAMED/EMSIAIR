package com.emsiair.emsiaiirmarrakech.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emsiair.emsiaiirmarrakech.Model.Réservation;

import java.util.List;

public interface RéservationRepository extends JpaRepository<Réservation, Long>{
    List<Réservation> findByUtilisateurId(Long userId);

}
