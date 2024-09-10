package com.pfe.gescar.controller;

import com.pfe.gescar.model.Chauffeur;
import com.pfe.gescar.service.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chauffeur")
public class ChauffeurController {

     @Autowired
     private ChauffeurService chauffeurService;

    // Create a new chauffeur
    @PostMapping
    public Chauffeur createChauffeur(@RequestBody Chauffeur chauffeur) {
        return chauffeurService.addChauffeur(chauffeur);
    }

    // Get all chauffeurs
    @GetMapping
    public List<Chauffeur> listChauffeurs() {
        return chauffeurService.getAllChauffeur();
    }

    // Get a chauffeur by ID
    @GetMapping("/{id}")
    public Optional<Chauffeur> getChauffeurById(@PathVariable Long id) {
        return chauffeurService.getChauffeurById(id);
    }

    // Update a chauffeur
    @PutMapping("/{id}")
    public Chauffeur updateChauffeur(@PathVariable Long id, @RequestBody Chauffeur updatedChauffeur) {
        return  chauffeurService.updateChauffeur(id, updatedChauffeur);

    }

    // Delete a chauffeur
    @DeleteMapping("/{id}")
    public String deleteChauffeur(@PathVariable Long id) {
         chauffeurService.deleteChauffeur(id);
        return "Chauffeur deleted";
    }

}
