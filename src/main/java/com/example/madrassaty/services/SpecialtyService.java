package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.SpecialtyDTO;
import com.example.madrassaty.dtos.response.SpecialtyResponse;
import com.example.madrassaty.models.Specialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SpecialtyService extends GlobalService<SpecialtyResponse, SpecialtyDTO> {
    Page<SpecialtyResponse> findAllBySchoolId(UUID schoolId, Pageable pageable);
}
