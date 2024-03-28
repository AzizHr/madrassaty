package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {
    Optional<Manager> findManagerByEmail(String email);
}
