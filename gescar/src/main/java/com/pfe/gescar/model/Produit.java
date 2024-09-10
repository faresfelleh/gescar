package com.pfe.gescar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduit;
    @Column(length=256)
    private String nomProduit;
    @Column(length=256)
    private String description;
    @Column(length=256)
    private String categorie;
    @Column(length=256)

    private Double stock;

    private Double prix;

}
