package com.emsiair.emsiaiirmarrakech.Model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Réservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;



    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "voyage_id")
    private Voyage voyage;

    @ManyToMany
    @JoinTable(name = "reservation_activite",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "activite_id"))
    private List<Activité> activites;

    public Réservation() {
    }

    public Réservation(Utilisateur utilisateur, Voyage voyage, List<Activité> activites) {
        this.utilisateur = utilisateur;
        this.voyage = voyage;
        this.activites = activites;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public List<Activité> getActivites() {
        return activites;
    }

    public void setActivites(List<Activité> activites) {
        this.activites = activites;
    }
}