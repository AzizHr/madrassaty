package com.example.madrassaty.services;

import com.example.madrassaty.dtos.response.ProfileResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TeacherService {
    Page<ProfileResponse> findAllBySchoolId(UUID schoolId, Pageable pageable);
    Page<ProfileResponse> findAllByClassId(UUID classId, Pageable pageable);
}
