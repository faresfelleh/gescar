package com.pfe.gescar.repository;

import com.pfe.gescar.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
