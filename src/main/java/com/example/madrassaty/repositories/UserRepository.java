package com.example.madrassaty.repositories;

import com.example.madrassaty.enums.StatusType;
import com.example.madrassaty.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findAllByStatus(StatusType status);
    Optional<User> findByEmail(String email);
}
