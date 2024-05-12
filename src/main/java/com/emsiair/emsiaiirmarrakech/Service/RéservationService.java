package com.emsiair.emsiaiirmarrakech.Service;

import com.emsiair.emsiaiirmarrakech.Model.Réservation;
import com.emsiair.emsiaiirmarrakech.Model.RéservationRequest;

import java.util.List;

public interface RéservationService {
    Réservation createRéservation(RéservationRequest réservationRequest);
    List<Réservation> getAllReservations();
}



