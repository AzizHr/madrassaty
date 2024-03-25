package com.example.madrassaty.repositories;

import com.example.madrassaty.enums.StatusType;
import com.example.madrassaty.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByStatus(StatusType status);
    User findByEmail(String email);
}
