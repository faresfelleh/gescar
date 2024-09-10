package com.pfe.gescar.repository;

import com.pfe.gescar.model.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChauffeurRepo extends JpaRepository<Chauffeur, Long> {
}
