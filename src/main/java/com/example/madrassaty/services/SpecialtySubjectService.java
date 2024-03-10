package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.SpecialtySubjectDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.SpecialtySubject;
import com.example.madrassaty.models.embeddables.SpecialtySubjectId;

public interface SpecialtySubjectService {
    SpecialtySubject save(SpecialtySubjectDTO specialtySubjectDTO);
    SpecialtySubject update(SpecialtySubjectDTO specialtySubjectDTO) throws NotFoundException;
    void delete(long specialtyId, long classId) throws NotFoundException;
    SpecialtySubject findById(SpecialtySubjectId id) throws NotFoundException;
}
