package com.example.madrassaty.repositories;

import com.example.madrassaty.models.School;
import com.example.madrassaty.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SchoolRepository extends JpaRepository<School, UUID> {
    @Query(value = "SELECT * FROM school WHERE id IN (SELECT school_id FROM users WHERE id = ?)", nativeQuery = true)
    Optional<School> findByManagerId(UUID managerId);
}
