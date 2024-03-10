package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Student;
import com.example.madrassaty.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findTeacherByEmail(String email);
    @Query(value = "SELECT * FROM users WHERE id IN (SELECT teacher_id FROM teacher_class WHERE class_id IN (SELECT id FROM class WHERE school_id = ?))", nativeQuery = true)
    List<Teacher> findAllBySchoolId(long schoolId);
    @Query(value = "SELECT * FROM users WHERE id IN (SELECT teacher_id FROM teacher_class WHERE class_id = ?)", nativeQuery = true)
    List<Teacher> findAllByClassId(long classId);
}
