package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, UUID> {
    Page<Subject> findAllBySchoolId(UUID schoolId, Pageable pageable);
}
