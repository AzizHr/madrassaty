package com.example.madrassaty.services;

import com.example.madrassaty.dtos.response.ProfileResponse;
import com.example.madrassaty.dtos.response.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface StudentService {

    Page<StudentResponse> findAllBySchoolId(UUID schoolId, Pageable pageable);
    Page<StudentResponse> findAllByClassId(UUID classId, Pageable pageable);
}
