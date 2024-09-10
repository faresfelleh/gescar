package com.pfe.gescar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idServvice;

    @Column(length=256)
    private String descriptionService;

    @Column(length=256)
    private String Service;


    private double CoutService;
}
