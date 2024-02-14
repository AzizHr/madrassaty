package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    List<Specialty> findAllBySchoolId(long schoolId);
}
