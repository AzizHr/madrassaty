package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.SchoolDTO;
import com.example.madrassaty.dtos.response.SchoolResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.School;
import com.example.madrassaty.repositories.SchoolRepository;
import com.example.madrassaty.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;

    @Override
    public SchoolResponse save(SchoolDTO schoolDTO) {
        School school = modelMapper.map(schoolDTO, School.class);
        return modelMapper.map(schoolRepository.save(school), SchoolResponse.class);
    }

    @Override
    public SchoolResponse update(SchoolDTO schoolDTO) throws NotFoundException {
        if(schoolRepository.findById(schoolDTO.getId()).isPresent()) {
            School school = modelMapper.map(schoolDTO, School.class);
            return modelMapper.map(schoolRepository.save(school), SchoolResponse.class);
        }
        throw new NotFoundException("No school found");
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        if(schoolRepository.findById(id).isPresent()) {
            schoolRepository.deleteById(id);
        }
        throw new NotFoundException("No school found");
    }

    @Override
    public SchoolResponse findById(UUID id) throws NotFoundException {
        if(schoolRepository.findById(id).isPresent()) {
            return modelMapper.map(schoolRepository.findById(id).get(), SchoolResponse.class);
        }
        throw new NotFoundException("No school found");
    }

    @Override
    public SchoolResponse findByManagerId(UUID managerId) throws NotFoundException {
        if(schoolRepository.findByManagerId(managerId).isPresent()) {
            return modelMapper.map(schoolRepository.findByManagerId(managerId).get(), SchoolResponse.class);
        }
        throw new NotFoundException("No school found");
    }
}
