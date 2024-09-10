package com.pfe.gescar.service;

import com.pfe.gescar.model.Vehicule;
import com.pfe.gescar.repository.VehiculeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService {
    @Autowired
    private VehiculeRepo vehiculeRepository;

    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }
    public Optional<Vehicule> findVehiculeById(long id) {
        return vehiculeRepository.findById(id);
    }
    public void deleteVehiculeById(long id) {
        vehiculeRepository.deleteById(id);
    }
    // Update a vehicle by ID
    public Vehicule updateVehicle(Long id, Vehicule updatedVehicle) {
        Optional<Vehicule> existingVehicleOpt = vehiculeRepository.findById(id);

        if (existingVehicleOpt.isPresent()) {
            Vehicule existingVehicle = existingVehicleOpt.get();
            existingVehicle.setMatriculeVehicule(updatedVehicle.getMatriculeVehicule());
            existingVehicle.setModeleVehicule(updatedVehicle.getModeleVehicule());
            existingVehicle.setMarqueVehicule(updatedVehicle.getMarqueVehicule());
            existingVehicle.setTypeVehicule(updatedVehicle.getTypeVehicule());
            existingVehicle.setKilometreinitVehicule(updatedVehicle.getKilometreinitVehicule());
            existingVehicle.setPuissanceVehicule(updatedVehicle.getPuissanceVehicule());
            existingVehicle.setCarbuantVehicule(updatedVehicle.getCarbuantVehicule());
            existingVehicle.setFinaceVehicule(updatedVehicle.getFinaceVehicule());
            existingVehicle.setNumcartegrise(updatedVehicle.getNumcartegrise());
            existingVehicle.setKilometrerouler(updatedVehicle.getKilometrerouler());
            return vehiculeRepository.save(existingVehicle);
        } else {
            return null;  // Or throw an exception if not found
        }
    }

}
