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

    @Query(value = "SELECT * FROM school WHERE id IN (SELECT school_id FROM class WHERE id IN (SELECT class_id FROM teacher_class WHERE teacher_id = ?))", nativeQuery = true)
    Optional<School> findByTeacherId(UUID teacherId);

    @Query(value = "SELECT * FROM school WHERE id IN (SELECT school_id FROM class WHERE id IN (SELECT class_id FROM users WHERE id = ?))", nativeQuery = true)
    Optional<School> findByStudentId(UUID studentId);
}
