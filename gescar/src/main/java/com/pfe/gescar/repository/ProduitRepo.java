package com.pfe.gescar.repository;

import com.pfe.gescar.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit, Long> {
}
