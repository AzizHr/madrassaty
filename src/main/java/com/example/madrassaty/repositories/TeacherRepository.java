package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findTeacherByEmail(String email);
    @Query(value = "SELECT * FROM users WHERE id IN (SELECT teacher_id FROM teacher_class WHERE class_id IN (SELECT id FROM class WHERE school_id = ?))", nativeQuery = true)
    Page<Teacher> findAllBySchoolId(long schoolId, Pageable pageable);
    @Query(value = "SELECT * FROM users WHERE id IN (SELECT teacher_id FROM teacher_class WHERE class_id = ?)", nativeQuery = true)
    Page<Teacher> findAllByClassId(long classId, Pageable pageable);
}
