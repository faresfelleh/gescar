package com.pfe.gescar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sinistre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSinistre;
    @Column(length =256)
    private String typeSinistre;
    @Column(length =256)
    private String descriptionSinistre;
    @Column(length =256)
    private String dateSinistre;
    @Column(length =256)
    private String lieuSinistre;
}
