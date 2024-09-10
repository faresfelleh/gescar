package com.pfe.gescar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idvehicule;

    @Column(length =256)
    private String matriculeVehicule;
    @Column(length =256)
    private String modeleVehicule;
    @Column(length =256)
    private String marqueVehicule;
    @Column(length =256)
    private String typeVehicule;
    private double kilometreinitVehicule;
    private double puissanceVehicule;
    @Column(length =256)
    private String carbuantVehicule;
    @Column(length =256)
    private String finaceVehicule;
    @Column(length =256)
    private String numcartegrise;

    private double kilometrerouler;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chauffeur_id")
    private Chauffeur chauffeur;

}
