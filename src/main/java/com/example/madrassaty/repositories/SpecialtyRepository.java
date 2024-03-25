package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Specialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    Page<Specialty> findAllBySchoolId(long schoolId, Pageable pageable);
}
