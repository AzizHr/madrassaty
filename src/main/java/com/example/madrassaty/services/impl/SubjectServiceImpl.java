package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.SubjectDTO;
import com.example.madrassaty.dtos.response.SubjectResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Subject;
import com.example.madrassaty.repositories.SubjectRepository;
import com.example.madrassaty.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    @Override
    public SubjectResponse save(SubjectDTO subjectDTO) {
        Subject subject = modelMapper.map(subjectDTO, Subject.class);
        return modelMapper.map(subjectRepository.save(subject), SubjectResponse.class);
    }

    @Override
    public SubjectResponse update(SubjectDTO subjectDTO) throws NotFoundException {
        if(subjectRepository.findById(subjectDTO.getId()).isPresent()) {
            Subject subject = modelMapper.map(subjectDTO, Subject.class);
            return modelMapper.map(subjectRepository.save(subject), SubjectResponse.class);
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
    public SubjectResponse findById(long id) throws NotFoundException {
        if(subjectRepository.findById(id).isPresent()) {
            return modelMapper.map(subjectRepository.findById(id).get(), SubjectResponse.class);
        }
        throw new NotFoundException("No subject found");
    }

    @Override
    public List<SubjectResponse> findAllBySpecialtyId(long specialtyId) {
        List<Subject> subjects = subjectRepository.findAllBySpecialtyId(specialtyId);
        return subjects.stream()
                .map(subject -> modelMapper.map(subject, SubjectResponse.class))
                .collect(Collectors.toList());
    }
}
