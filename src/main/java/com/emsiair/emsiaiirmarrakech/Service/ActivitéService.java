package com.emsiair.emsiaiirmarrakech.Service;

import com.emsiair.emsiaiirmarrakech.Model.Activité;
import com.emsiair.emsiaiirmarrakech.Repository.ActivitéRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActivitéService {

    @Autowired
    private ActivitéRepository activitéRepository;

    public List<Activité> getAllActivités() {
        return activitéRepository.findAll();
    }

    public Activité getActivitéById(Long id) {
        return activitéRepository.findById(id).orElse(null);
    }

    public Activité addActivité(Activité activité) {
        return activitéRepository.save(activité);
    }

    public Activité updateActivité(Long id, Activité updatedActivité) {
        Activité existingActivité = activitéRepository.findById(id).orElse(null);
        if (existingActivité != null) {
            existingActivité.setNom(updatedActivité.getNom());
            existingActivité.setDescription(updatedActivité.getDescription());
            existingActivité.setPrix(updatedActivité.getPrix());
            return activitéRepository.save(existingActivité);
        }
        return null;
    }

    public void deleteActivité(Long id) {
        activitéRepository.deleteById(id);
    }
}
