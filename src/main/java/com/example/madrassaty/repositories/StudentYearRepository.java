package com.example.madrassaty.repositories;

import com.example.madrassaty.models.StudentYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentYearRepository extends JpaRepository<StudentYear, UUID> {
    List<StudentYear> findAllByStudentId(UUID studentId);
}
