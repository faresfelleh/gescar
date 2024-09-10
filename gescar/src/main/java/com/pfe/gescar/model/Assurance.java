package com.pfe.gescar.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Assurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAssurance;
    @Column(length =256)
    private String numAssurance;
    @Column(length =256)
    private String nomAgenceAssurance;
    @Column(length =256)
    private String dateDebutAssurance;
    @Column(length =256)
    private String dateFinAssurance;


}
