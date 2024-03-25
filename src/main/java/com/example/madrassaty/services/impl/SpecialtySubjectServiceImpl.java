package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.SpecialtySubjectDTO;
import com.example.madrassaty.exceptions.AlreadyAssignedException;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.SpecialtySubject;
import com.example.madrassaty.models.embeddables.SpecialtySubjectId;
import com.example.madrassaty.repositories.SpecialtySubjectRepository;
import com.example.madrassaty.services.SpecialtySubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialtySubjectServiceImpl implements SpecialtySubjectService {

    private final SpecialtySubjectRepository specialtySubjectRepository;

    @Override
    public SpecialtySubject save(SpecialtySubjectDTO specialtySubjectDTO) throws AlreadyAssignedException {
        SpecialtySubjectId specialtySubjectId = new SpecialtySubjectId();
        specialtySubjectId.setSpecialtyId(specialtySubjectDTO.getSpecialtyId());
        specialtySubjectId.setSubjectId(specialtySubjectDTO.getSubjectId());
        if(specialtySubjectRepository.findById(specialtySubjectId).isPresent()) {
            throw new AlreadyAssignedException("This subject is already assigned to this specialty");
        } else {
            SpecialtySubject specialtySubject = new SpecialtySubject();
            specialtySubject.setId(specialtySubjectId);
            return specialtySubjectRepository.save(specialtySubject);
        }
    }

    @Override
    public SpecialtySubject update(SpecialtySubjectDTO specialtySubjectDTO) throws NotFoundException {
        SpecialtySubjectId specialtySubjectId = new SpecialtySubjectId();
        specialtySubjectId.setSpecialtyId(specialtySubjectDTO.getSpecialtyId());
        specialtySubjectId.setSubjectId(specialtySubjectDTO.getSubjectId());
        if(specialtySubjectRepository.findById(specialtySubjectId).isPresent()) {
            SpecialtySubject specialtySubject = new SpecialtySubject();
            specialtySubject.setId(specialtySubjectId);
            return specialtySubjectRepository.save(specialtySubject);
        }
        throw new NotFoundException("No specialty-subject found");
    }

    @Override
    public void delete(long specialtyId, long subjectId) throws NotFoundException {
        SpecialtySubjectId specialtySubjectId = new SpecialtySubjectId();
        specialtySubjectId.setSpecialtyId(specialtyId);
        specialtySubjectId.setSubjectId(subjectId);
        if(specialtySubjectRepository.findById(specialtySubjectId).isPresent()) {
            specialtySubjectRepository.deleteById(specialtySubjectId);
            return;
        }
        throw new NotFoundException("No specialty-subject found");
    }

    @Override
    public SpecialtySubject findById(SpecialtySubjectId id) throws NotFoundException {
        return null;
    }
}
