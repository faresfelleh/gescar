package com.pfe.gescar.repository;

import com.pfe.gescar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
