package com.emsiair.emsiaiirmarrakech.Service;

import com.emsiair.emsiaiirmarrakech.Model.*;
import com.emsiair.emsiaiirmarrakech.Repository.ActivitéRepository;
import com.emsiair.emsiaiirmarrakech.Repository.HotelRepository;
import com.emsiair.emsiaiirmarrakech.Repository.RéservationRepository;
import com.emsiair.emsiaiirmarrakech.Repository.UtilisateurRepository;
import com.emsiair.emsiaiirmarrakech.Repository.VoyageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RéservationServiceImpl implements RéservationService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private VoyageRepository voyageRepository;

    @Autowired
    private ActivitéRepository activitéRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RéservationRepository réservationRepository;
    @Override
    public List<Réservation> getAllReservations() {
        return réservationRepository.findAll();
    }

    @Override
    public Réservation createRéservation(RéservationRequest réservationRequest) {
        // Récupérer les entités nécessaires à partir des IDs
        Utilisateur utilisateur = utilisateurRepository.findById(réservationRequest.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec ID: " + réservationRequest.getUserId()));

        Voyage voyage = voyageRepository.findById(réservationRequest.getVoyageId())
                .orElseThrow(() -> new EntityNotFoundException("Voyage non trouvé avec ID: " + réservationRequest.getVoyageId()));

        Hotel hotel = hotelRepository.findById(réservationRequest.getHotelId())
                .orElseThrow(() -> new EntityNotFoundException("Hôtel non trouvé avec ID: " + réservationRequest.getHotelId()));

        List<Activité> activités = activitéRepository.findAllById(réservationRequest.getActiviteIds());

        // Créer la réservation
        Réservation réservation = new Réservation();
        réservation.setUtilisateur(utilisateur);
        réservation.setVoyage(voyage);
        réservation.setHotel(hotel);
        réservation.setActivites(activités);

        // Enregistrer la réservation
        return réservationRepository.save(réservation);
    }
}
