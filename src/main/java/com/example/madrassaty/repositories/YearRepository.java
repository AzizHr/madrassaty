package com.example.madrassaty.repositories;

import com.example.madrassaty.models.Year;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YearRepository extends JpaRepository<Year, Long> {
    List<Year> findAllBySchoolId(long schoolId);
}
