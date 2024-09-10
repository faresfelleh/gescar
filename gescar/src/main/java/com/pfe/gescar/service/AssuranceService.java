package com.pfe.gescar.service;

import com.pfe.gescar.model.Assurance;
import com.pfe.gescar.repository.AssuranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuranceService {

    @Autowired
    private AssuranceRepo assuranceRepo;

    public Assurance addAssurance(Assurance assurance ) {
        return assuranceRepo.save(assurance);
    }
    public List<Assurance> getAllAssurance() {
        return assuranceRepo.findAll();
    }
    public Optional<Assurance> getAssuranceById(long id) {
            return assuranceRepo.findById(id);
    }
    public Assurance updateAssurance(long id , Assurance updatedAssurance) {
        return assuranceRepo.findById(id)
                .map(assurance -> {
                    assurance.setNumAssurance(updatedAssurance.getNumAssurance());
                    assurance.setNomAgenceAssurance(updatedAssurance.getNomAgenceAssurance());
                    assurance.setDateDebutAssurance(updatedAssurance.getDateDebutAssurance());
                    assurance.setDateFinAssurance(updatedAssurance.getDateFinAssurance());
                    return assuranceRepo.save(assurance);
                }).orElse(null);  // Handle case where Assurance is not found

    }
    public void deleteAssurance(long id) {
        assuranceRepo.deleteById(id);
    }
}
