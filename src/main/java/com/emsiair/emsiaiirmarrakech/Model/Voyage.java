package com.emsiair.emsiaiirmarrakech.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Voyage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private Date dateDepart;
    private int dureeSejour;
    private double prix;
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Réservation réservation;



    public Voyage() {
    }

    public Voyage(String destination, Date dateDepart, int dureeSejour, double prix) {
        this.destination = destination;
        this.dateDepart = dateDepart;
        this.dureeSejour = dureeSejour;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getDureeSejour() {
        return dureeSejour;
    }

    public void setDureeSejour(int dureeSejour) {
        this.dureeSejour = dureeSejour;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}

