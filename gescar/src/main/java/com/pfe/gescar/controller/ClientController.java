package com.pfe.gescar.controller;

import com.pfe.gescar.model.Client;
import com.pfe.gescar.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientServices;

    @PostMapping()
    public Client saveClient(@RequestBody Client client) {
        return clientServices.addClient(client);

    }

    @GetMapping()
    public List<Client> ListClients() {
        return clientServices.getAllClients();
    }
    @GetMapping("/{id}")
    public Optional<Client> ClientById(@PathVariable long id) {
        return clientServices.getClientById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        Client client = clientServices.updateClient(id, updatedClient);

        if (client == null) {
            return ResponseEntity.notFound().build(); // Client not found
        } else {
            return ResponseEntity.ok(client); // Successfully updated
        }
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable long id) {
        clientServices.deleteClientById(id);
        return "Client deleted";
    }


}
