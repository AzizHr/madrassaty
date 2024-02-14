package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.SubjectDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Subject;
import com.example.madrassaty.repositories.SubjectRepository;
import com.example.madrassaty.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    @Override
    public Subject save(SubjectDTO subjectDTO) {
        Subject subject = modelMapper.map(subjectDTO, Subject.class);
        return subjectRepository.save(subject);
    }

    @Override
    public Subject update(SubjectDTO subjectDTO) throws NotFoundException {
        if(subjectRepository.findById(subjectDTO.getId()).isPresent()) {
            Subject subject = modelMapper.map(subjectDTO, Subject.class);
            return subjectRepository.save(subject);
        }
        throw new NotFoundException("No subject found");
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if(subjectRepository.findById(id).isPresent()) {
            subjectRepository.deleteById(id);
        }
        throw new NotFoundException("No subject found");
    }

    @Override
    public Subject findById(long id) throws NotFoundException {
        if(subjectRepository.findById(id).isPresent()) {
            return subjectRepository.findById(id).get();
        }
        throw new NotFoundException("No subject found");
    }

    @Override
    public List<Subject> findAllBySpecialtyId(long specialtyId) {
        return null;
    }
}
