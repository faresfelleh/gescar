package com.pfe.gescar.service;

import com.pfe.gescar.model.Client;
import com.pfe.gescar.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;


    public Client addClient(Client client) {
        return clientRepo.save(client);
    }
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }


    public Optional<Client> getClientById(long id) {
        return clientRepo.findById(id);

    }
    public void deleteClientById(long id) {

        clientRepo.deleteById(id);
    }
    public Client updateClient(Long id , Client client) {
        Optional<Client> existingClientOptional = clientRepo.findById(id);

        if (existingClientOptional.isPresent()) {
            Client client1 = existingClientOptional.get();
            client1.setNomClient(client.getNomClient());
            client1.setMatClient(client.getMatClient());
            client1.setAdressClient(client.getAdressClient());
            client1.setEmailClient(client.getEmailClient());
            client1.setTelephoneClient(client.getTelephoneClient());
            return clientRepo.save(client1);
        } else {
            return null; // or throw an exception (e.g., ClientNotFoundException)
        }


    }
}
