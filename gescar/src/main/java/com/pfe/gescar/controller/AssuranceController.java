package com.pfe.gescar.controller;

import com.pfe.gescar.model.Assurance;
import com.pfe.gescar.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assurance")
public class AssuranceController {

    @Autowired
    private AssuranceService assuranceService;

    // Create a new Assurance
    @PostMapping
    public Assurance createAssurance(@RequestBody Assurance assurance) {
        return assuranceService.addAssurance(assurance);
    }

    // Get all Assurances
    @GetMapping
    public List<Assurance> listAssurances() {
        return assuranceService.getAllAssurance();
    }

    // Get Assurance by ID
    @GetMapping("/{id}")
    public Optional<Assurance> AssuranceById(@PathVariable Long id) {
        return  assuranceService.getAssuranceById(id);

    }

    // Update an Assurance
    @PutMapping("/{id}")
    public ResponseEntity<Assurance> updateAssurance(@PathVariable Long id, @RequestBody Assurance updatedAssurance) {
        Assurance assurance = assuranceService.updateAssurance(id, updatedAssurance);
        if (assurance != null) {
            return ResponseEntity.ok(assurance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an Assurance
    @DeleteMapping("/{id}")
    public String deleteAssurance(@PathVariable long id) {
         assuranceService.deleteAssurance(id);
         return "Assurance deleted";
    }

}
