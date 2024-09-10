package com.pfe.gescar.service;

import com.pfe.gescar.model.Produit;
import com.pfe.gescar.repository.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepo produitRepo;

    public Produit addProduit(Produit produit) {
        return produitRepo.save(produit);
    }

    public List<Produit> getAllProduits() {

        return produitRepo.findAll();
    }

    public Optional<Produit> getProduitById(long id) {
        return produitRepo.findById(id);
    }


    public void deleteProduitById(long  id) {
        produitRepo.deleteById(id);
    }

    public Produit updateProduit(Long id , Produit produit) {

        Optional<Produit> existingProduit = produitRepo.findById(id);

        if (existingProduit.isPresent()) {
            Produit Produit1 = existingProduit.get();
            Produit1.setNomProduit(produit.getNomProduit());
            Produit1.setDescription(produit.getDescription());
            Produit1.setCategorie(produit.getCategorie());
            Produit1.setPrix(produit.getPrix());
            Produit1.setStock(produit.getStock());
            return produitRepo.save(Produit1);
        } else {
            return null; // or throw an exception (e.g., ClientNotFoundException)
        }
    }
}
