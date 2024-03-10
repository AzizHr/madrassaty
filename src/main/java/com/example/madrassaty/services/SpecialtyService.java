package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.SpecialtyDTO;
import com.example.madrassaty.dtos.response.SpecialtyResponse;
import com.example.madrassaty.models.Specialty;
import java.util.List;

public interface SpecialtyService extends GlobalService<SpecialtyResponse, SpecialtyDTO> {
    List<SpecialtyResponse> findAllBySchoolId(long schoolId);
}
