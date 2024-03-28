package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Year;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface YearRepository extends JpaRepository<Year, UUID> {
    List<Year> findAllBySchoolId(UUID schoolId);
}
