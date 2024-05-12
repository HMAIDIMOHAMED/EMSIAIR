package com.emsiair.emsiaiirmarrakech.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String destination;

    public List<Réservation> getRéservations() {
        return réservations;
    }

    public void setRéservations(List<Réservation> réservations) {
        this.réservations = réservations;
    }

    public List<Activité> getActivités() {
        return activités;
    }

    public void setActivités(List<Activité> activités) {
        this.activités = activités;
    }

    private String servicesOfferts;
    private double tarifs;

    @JsonIgnore
    @OneToMany(mappedBy = "hotel")
    private List<Réservation> réservations;
    @ManyToMany
    @JoinTable(name = "hotel_activité",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "activité_id"))
    private List<Activité> activités;

    public Hotel() {
    }

    public Hotel(String nom, String destination, String servicesOfferts, double tarifs) {
        this.nom = nom;
        this.destination = destination;
        this.servicesOfferts = servicesOfferts;
        this.tarifs = tarifs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getServicesOfferts() {
        return servicesOfferts;
    }

    public void setServicesOfferts(String servicesOfferts) {
        this.servicesOfferts = servicesOfferts;
    }

    public double getTarifs() {
        return tarifs;
    }

    public void setTarifs(double tarifs) {
        this.tarifs = tarifs;
    }
}