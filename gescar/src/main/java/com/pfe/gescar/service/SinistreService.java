package com.pfe.gescar.service;

import com.pfe.gescar.model.Sinistre;
import com.pfe.gescar.repository.SinistreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinistreService {

    @Autowired
    private SinistreRepo sinistreRepo;


    public Sinistre addSinistre(Sinistre sinistre) {
        return  sinistreRepo.save(sinistre);
    }
    public List<Sinistre> findAllSinistre() {
        return sinistreRepo.findAll();
    }
    public Optional<Sinistre> findSinistreById(long id) {
        return sinistreRepo.findById(id);
    }
    public void deleteSinistreById(long id) {
        sinistreRepo.deleteById(id);
    }
    public Sinistre updateSinistre(Long id, Sinistre sinistre) {
        Optional<Sinistre> existingSinistre = sinistreRepo.findById(id);

        if (existingSinistre.isPresent()) {
            Sinistre sin = existingSinistre.get();
            sin.setTypeSinistre(sinistre.getTypeSinistre());
            sin.setDescriptionSinistre(sinistre.getDescriptionSinistre());
            sin.setDateSinistre(sinistre.getDateSinistre());
            sin.setLieuSinistre(sinistre.getLieuSinistre());
            return sinistreRepo.save(sin);
        } else {
            return null; // Handle the case where sinistre is not found (or throw exception)
        }
    }
}



