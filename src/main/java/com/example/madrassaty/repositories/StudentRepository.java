package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Optional<Student> findStudentByEmail(String email);
    @Query(value = "SELECT * FROM users WHERE specialty_id IN (SELECT id FROM specialty WHERE school_id = ?)", nativeQuery = true)
    Page<Student> findAllBySchoolId(UUID schoolId, Pageable pageable);
    Page<Student> findAllBy_class_Id(UUID classId, Pageable pageable);
}
