package com.pfe.gescar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chauffeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChauffeur;
    @Column(length =256)
    private String nomChauffeur;
    @Column(length =256)
    private String prenomChauffeur;
    @Column(length =256)
    private String adresseChauffeur;
    @Column(length =256)
    private String telephoneChauffeur;
    @Column(length =256)
    private String emailChauffeur;
    @Column(length =256)
    private String permisChauffeur;

    @OneToMany(mappedBy = "chauffeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicule> vehicules;


}
