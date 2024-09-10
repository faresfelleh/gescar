package com.pfe.gescar.controller;

import com.pfe.gescar.model.Sinistre;
import com.pfe.gescar.service.SinistreService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sinistre")
public class SinistreController {

    @Autowired
    private SinistreService sinistreService;


    @PostMapping
    public Sinistre saveSinistre(@RequestBody Sinistre sinistre) {
        return sinistreService.addSinistre(sinistre);
    }


    @GetMapping
    public List<Sinistre> listSinistres() {
        return sinistreService.findAllSinistre();
    }


    @GetMapping("/{id}")
    public Optional<Sinistre> getSinistreById(@PathVariable Long id) {
       return sinistreService.findSinistreById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Sinistre> updateSinistre(@PathVariable Long id, @RequestBody Sinistre updatedSinistre) {
        Sinistre sinistre = sinistreService.updateSinistre(id, updatedSinistre);

        if (sinistre != null) {
            return ResponseEntity.ok(sinistre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public String deleteSinistre(@PathVariable Long id) {
        sinistreService.deleteSinistreById(id);
        return "sinistre deleted;";
    }
}
