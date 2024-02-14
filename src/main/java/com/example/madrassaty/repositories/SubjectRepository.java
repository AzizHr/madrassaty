package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

//    List<Subject> findAllBySpecialtyId(long specialtyId);
}
