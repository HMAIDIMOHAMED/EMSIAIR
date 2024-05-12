package com.emsiair.emsiaiirmarrakech.Controller;

import com.emsiair.emsiaiirmarrakech.Model.Réservation;
import com.emsiair.emsiaiirmarrakech.Model.RéservationRequest;
import com.emsiair.emsiaiirmarrakech.Service.RéservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class RéservationController {

    @Autowired
    private RéservationService réservationService;

    @PostMapping
    public Réservation createRéservation(@RequestBody RéservationRequest réservationRequest) {
        return réservationService.createRéservation(réservationRequest);
    }
    @GetMapping
    public List<Réservation> getAllReservations() {
        return réservationService.getAllReservations();
    }
    }

