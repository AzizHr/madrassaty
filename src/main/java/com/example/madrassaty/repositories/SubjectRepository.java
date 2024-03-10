package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Student;
import com.example.madrassaty.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query(value = "SELECT * FROM subject WHERE id IN (SELECT subject_id FROM specialty_subject WHERE specialty_id = ?)", nativeQuery = true)
    List<Subject> findAllBySpecialtyId(long specialtyId);
}
