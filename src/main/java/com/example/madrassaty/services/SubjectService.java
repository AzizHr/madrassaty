package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.SubjectDTO;
import com.example.madrassaty.dtos.response.SubjectResponse;
import com.example.madrassaty.models.Subject;
import java.util.List;

public interface SubjectService extends GlobalService<SubjectResponse, SubjectDTO> {
    List<SubjectResponse> findAllBySpecialtyId(long specialtyId);
}
