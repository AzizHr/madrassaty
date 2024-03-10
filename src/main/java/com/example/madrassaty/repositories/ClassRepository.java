package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {
    List<Class> findAllBySchoolId(long schoolId);
    @Query(value = "SELECT * FROM class WHERE id IN (SELECT class_id FROM teacher_class WHERE teacher_id = ?)", nativeQuery = true)
    List<Class> findAllByTeacherId(long teacherId);
}
