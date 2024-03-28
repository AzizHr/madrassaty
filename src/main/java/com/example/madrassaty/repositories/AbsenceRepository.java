package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AbsenceRepository extends JpaRepository<Absence, UUID> {
    List<Absence> findAllByStudentId(UUID studentId);
}
