package com.pfe.gescar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;

    @Column(length=256)
    private String nomClient;

    @Column(length =256)
    private String matClient;

    @Column(length = 256)
    private String telephoneClient;

    @Column(length = 256)
    private String emailClient;

    @Column(length = 256)
    private String adressClient;

}
