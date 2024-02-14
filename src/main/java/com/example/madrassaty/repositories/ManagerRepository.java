package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findManagerByEmail(String email);
}
