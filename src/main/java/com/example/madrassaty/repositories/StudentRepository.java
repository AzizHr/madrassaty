package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    @Query(value = "SELECT * FROM users WHERE specialty_id IN (SELECT id FROM specialty WHERE school_id = ?)", nativeQuery = true)
    List<Student> findAllBySchoolId(long schoolId);
    List<Student> findAllBy_class_Id(long classId);
}
