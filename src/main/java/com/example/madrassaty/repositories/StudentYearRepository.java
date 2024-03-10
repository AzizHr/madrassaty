package com.example.madrassaty.repositories;

import com.example.madrassaty.models.StudentYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentYearRepository extends JpaRepository<StudentYear, Long> {
    List<StudentYear> findAllByStudentId(long studentId);
}
