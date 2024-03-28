package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Specialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecialtyRepository extends JpaRepository<Specialty, UUID> {
    Page<Specialty> findAllBySchoolId(UUID schoolId, Pageable pageable);
}
