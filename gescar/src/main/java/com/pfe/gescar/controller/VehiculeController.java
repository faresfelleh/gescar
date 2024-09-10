package com.pfe.gescar.controller;

import com.pfe.gescar.model.Vehicule;
import com.pfe.gescar.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    // Create a new vehicle
    @PostMapping
    public Vehicule createVehicle(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    // Get all vehicles
    @GetMapping
    public List<Vehicule> ListVehicles() {
        return vehiculeService.getAllVehicules();
    }

    // Get a vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getVehicleById(@PathVariable Long id) {
        Optional<Vehicule> vehicle = vehiculeService.findVehiculeById(id);
        return vehicle.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a vehicle by ID
    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> updateVehicle(@PathVariable Long id, @RequestBody Vehicule updatedVehicule) {
        Vehicule vehicule = vehiculeService.updateVehicle(id, updatedVehicule);
        if (vehicule != null) {
            return ResponseEntity.ok(vehicule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a vehicle by ID
    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehiculeService.deleteVehiculeById(id);
      return "vehicule deleted: " ;
    }

}
