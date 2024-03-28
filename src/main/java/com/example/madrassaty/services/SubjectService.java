package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.SubjectDTO;
import com.example.madrassaty.dtos.response.SubjectResponse;
import com.example.madrassaty.models.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SubjectService extends GlobalService<SubjectResponse, SubjectDTO> {
    Page<SubjectResponse> findAllBySchoolId(UUID schoolId, Pageable pageable);
}
