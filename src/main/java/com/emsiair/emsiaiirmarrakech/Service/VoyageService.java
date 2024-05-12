package com.emsiair.emsiaiirmarrakech.Service;

import com.emsiair.emsiaiirmarrakech.Model.Voyage;

import java.util.Date;
import java.util.List;

public interface VoyageService {
    List<Voyage> getAllVoyages();
    Voyage addVoyage(Voyage voyage);
    List<Voyage> filterVoyages(String destination, Date dateDepart, Double prixMin, Double prixMax);
}
