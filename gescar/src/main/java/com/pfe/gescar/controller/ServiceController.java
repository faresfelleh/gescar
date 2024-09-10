package com.pfe.gescar.controller;



import com.pfe.gescar.model.Services;
import com.pfe.gescar.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServicesService servicesServ;

    @PostMapping
    public Services saveService(Services service) {
        return servicesServ.addService(service);
    }

    @GetMapping
    public List<Services> ListServices() {
        return  servicesServ.getAllServices();
    }

    @GetMapping  ("/{id}")
    public Optional<Services> GetService(@PathVariable long id) {
        return servicesServ.getServiceById(id);
    }

    @DeleteMapping("/{id}")
    public String DeleteService(@PathVariable long id) {
        servicesServ.deleteService(id);
        return "Service deleted";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Services> updateServices(@PathVariable long id, @RequestBody Services service) {
        Services serv = servicesServ.updateService(id, service );

        if (serv == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(serv);
        }

}
}
