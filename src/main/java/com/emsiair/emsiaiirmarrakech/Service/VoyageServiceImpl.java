package com.emsiair.emsiaiirmarrakech.Service;

import com.emsiair.emsiaiirmarrakech.Model.Voyage;
import com.emsiair.emsiaiirmarrakech.Repository.VoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VoyageServiceImpl implements VoyageService {

    @Autowired
    private VoyageRepository voyageRepository;

    @Override
    public List<Voyage> getAllVoyages() {
        return voyageRepository.findAll();
    }

    @Override
    public Voyage addVoyage(Voyage voyage) {
        return voyageRepository.save(voyage);
    }
    @Override
    public List<Voyage> filterVoyages(String destination, Date dateDepart, Double prixMin, Double prixMax) {

        if (destination != null && dateDepart != null && prixMin != null && prixMax != null) {
            return voyageRepository.findByDestinationAndDateDepartAndPrixBetween(destination, dateDepart, prixMin, prixMax);
        } else {
            return voyageRepository.findAll();
        }
    }
}
