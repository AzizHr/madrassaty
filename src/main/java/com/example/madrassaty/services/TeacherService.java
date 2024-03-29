package com.example.madrassaty.services;

import com.example.madrassaty.dtos.response.ProfileResponse;
import com.example.madrassaty.dtos.response.TeacherResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TeacherService {
    Page<TeacherResponse> findAllBySchoolId(UUID schoolId, Pageable pageable);
    Page<TeacherResponse> findAllByClassId(UUID classId, Pageable pageable);
}
