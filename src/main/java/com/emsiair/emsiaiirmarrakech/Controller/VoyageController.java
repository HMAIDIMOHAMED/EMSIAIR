package com.emsiair.emsiaiirmarrakech.Controller;

import com.emsiair.emsiaiirmarrakech.Model.Voyage;
import com.emsiair.emsiaiirmarrakech.Service.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/voyages")
public class VoyageController {

    @Autowired
    private VoyageService voyageService;

    @GetMapping
    public List<Voyage> getVoyages() {
        return voyageService.getAllVoyages();
    }

    @PostMapping
    public Voyage addVoyage(@RequestBody Voyage voyage) {
        return voyageService.addVoyage(voyage);
    }

    @GetMapping("/filter")
    public List<Voyage> filterVoyages(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) Date dateDepart,
            @RequestParam(required = false) Double prixMin,
            @RequestParam(required = false) Double prixMax) {
        return voyageService.filterVoyages(destination, dateDepart, prixMin, prixMax);
    }}


