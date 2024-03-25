package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    @Query(value = "SELECT * FROM users WHERE specialty_id IN (SELECT id FROM specialty WHERE school_id = ?)", nativeQuery = true)
    Page<Student> findAllBySchoolId(long schoolId, Pageable pageable);
    Page<Student> findAllBy_class_Id(long classId, Pageable pageable);
}
