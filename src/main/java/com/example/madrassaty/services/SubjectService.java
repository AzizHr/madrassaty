package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.SubjectDTO;
import com.example.madrassaty.models.Subject;
import java.util.List;

public interface SubjectService extends GlobalService<Subject, SubjectDTO> {
    List<Subject> findAllBySpecialtyId(long specialtyId);
}
