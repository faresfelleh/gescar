package com.pfe.gescar.controller;

import com.pfe.gescar.model.Produit;
import com.pfe.gescar.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produit")
public class ProduitController {


    @Autowired
    private ProduitService produitService;

    @PostMapping
    public Produit saveProduit(@RequestBody Produit produit) {
        return  produitService.addProduit(produit);
    }
    @GetMapping
    public List<Produit> ListProduits() {
        return produitService.getAllProduits();
    }
    @GetMapping("/{id}")
    public Optional<Produit> produitById(@PathVariable int id) {
        return produitService.getProduitById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteProduit(@PathVariable int id) {
        produitService.deleteProduitById(id);
        return "Produit deleted";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit updatedProduit) {
        Produit produit = produitService.updateProduit(id, updatedProduit);

        if (produit == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(produit);
        }
    }

}
