package com.pfe.gescar.service;

import com.pfe.gescar.model.Services;
import com.pfe.gescar.repository.ServicesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {


    @Autowired
    private ServicesRepo servicesRepo;


    public Services addService(Services service) {
        return servicesRepo.save(service);
    }
    public List<Services> getAllServices() {
        return servicesRepo.findAll();
    }


    public Optional<Services> getServiceById(Long id) {
        return servicesRepo.findById(id);
    }

    // Update a product
    public Services updateService(Long id, Services service) {
        Optional<Services> existingService = servicesRepo.findById(id);

        if (existingService.isPresent()) {
            Services serv = existingService.get();
            serv.setDescriptionService(service.getDescriptionService());
            serv.setService(service.getService());
            serv.setCoutService(service.getCoutService());
            return servicesRepo.save(serv);
        } else {
            return null; // Or throw a custom exception
        }
    }

    // Delete a product
    public boolean deleteService(Long id) {
        Optional<Services> product = servicesRepo.findById(id);
        if (product.isPresent()) {
            servicesRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
