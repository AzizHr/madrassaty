package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.SchoolDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.School;
import com.example.madrassaty.repositories.SchoolRepository;
import com.example.madrassaty.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;

    @Override
    public School save(SchoolDTO schoolDTO) {
        School school = modelMapper.map(schoolDTO, School.class);
        return schoolRepository.save(school);
    }

    @Override
    public School update(SchoolDTO schoolDTO) throws NotFoundException {
        if(schoolRepository.findById(schoolDTO.getId()).isPresent()) {
            School school = modelMapper.map(schoolDTO, School.class);
            return schoolRepository.save(school);
        }
        throw new NotFoundException("No school found");
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if(schoolRepository.findById(id).isPresent()) {
            schoolRepository.deleteById(id);
        }
        throw new NotFoundException("No school found");
    }

    @Override
    public School findById(long id) throws NotFoundException {
        if(schoolRepository.findById(id).isPresent()) {
            return schoolRepository.findById(id).get();
        }
        throw new NotFoundException("No school found");
    }
}
