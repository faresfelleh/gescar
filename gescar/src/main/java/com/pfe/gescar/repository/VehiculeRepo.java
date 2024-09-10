package com.pfe.gescar.repository;

import com.pfe.gescar.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {
}
