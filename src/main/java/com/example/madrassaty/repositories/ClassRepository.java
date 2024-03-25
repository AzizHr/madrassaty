package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassRepository extends JpaRepository<Class, Long> {
    Page<Class> findAllBySchoolId(long schoolId, Pageable pageable);
    @Query(value = "SELECT * FROM class WHERE id IN (SELECT class_id FROM teacher_class WHERE teacher_id = ?)", nativeQuery = true)
    Page<Class> findAllByTeacherId(long teacherId, Pageable pageable);
}
