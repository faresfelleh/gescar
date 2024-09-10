package com.pfe.gescar.service;

import com.pfe.gescar.model.Chauffeur;
import com.pfe.gescar.repository.ChauffeurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChauffeurService {

    @Autowired
    private ChauffeurRepo chauffeurRepo;
    public Chauffeur addChauffeur(Chauffeur chauffeur) {
        return chauffeurRepo.save(chauffeur);
    }
    public Optional<Chauffeur> getChauffeurById(long id) {
        return chauffeurRepo.findById(id);
    }
    public List<Chauffeur> getAllChauffeur() {
        return chauffeurRepo.findAll();
    }
    public Chauffeur updateChauffeur(long id , Chauffeur chauffeur){
        return chauffeurRepo.findById(id)
                .map(chauff -> {
                    chauff.setNomChauffeur(chauffeur.getNomChauffeur());
                    chauff.setPrenomChauffeur(chauffeur.getPrenomChauffeur());
                    chauff.setAdresseChauffeur(chauffeur.getPermisChauffeur());
                    chauff.setEmailChauffeur(chauffeur.getEmailChauffeur());
                    chauff.setTelephoneChauffeur(chauffeur.getTelephoneChauffeur());
                    chauff.setPermisChauffeur(chauffeur.getPermisChauffeur());
                    return chauffeurRepo.save(chauffeur);
                }).orElse(null);  // Handle chauffeur not found case
    }
    public void deleteChauffeur(long id) {
        chauffeurRepo.deleteById(id);
    }
}
