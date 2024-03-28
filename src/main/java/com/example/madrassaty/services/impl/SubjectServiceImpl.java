package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.SubjectDTO;
import com.example.madrassaty.dtos.response.SubjectResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Subject;
import com.example.madrassaty.repositories.SchoolRepository;
import com.example.madrassaty.repositories.SubjectRepository;
import com.example.madrassaty.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;

    @Override
    public SubjectResponse save(SubjectDTO subjectDTO) throws NotFoundException {
        Subject subject = modelMapper.map(subjectDTO, Subject.class);
        subject.setSchool(schoolRepository.findById(subjectDTO.getSchoolId()).orElseThrow(() -> new NotFoundException("No school found")));
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
    public void delete(UUID id) throws NotFoundException {
        if(subjectRepository.findById(id).isPresent()) {
            subjectRepository.deleteById(id);
        }
        throw new NotFoundException("No subject found");
    }

    @Override
    public SubjectResponse findById(UUID id) throws NotFoundException {
        if(subjectRepository.findById(id).isPresent()) {
            return modelMapper.map(subjectRepository.findById(id).get(), SubjectResponse.class);
        }
        throw new NotFoundException("No subject found");
    }

    @Override
    public Page<SubjectResponse> findAllBySchoolId(UUID schoolId, Pageable pageable) {
        Page<Subject> subjectPage = subjectRepository.findAllBySchoolId(schoolId, pageable);

        return new PageImpl<>(
                subjectPage.getContent().stream()
                        .map(subject -> modelMapper.map(subject, SubjectResponse.class))
                        .collect(Collectors.toList()),
                subjectPage.getPageable(),
                subjectPage.getTotalElements()
        );
    }
}
