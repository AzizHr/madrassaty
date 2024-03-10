package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findAllByStudentId(long studentId);
}
