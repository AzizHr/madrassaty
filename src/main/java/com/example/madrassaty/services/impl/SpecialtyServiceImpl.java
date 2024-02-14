package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.SpecialtyDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Specialty;
import com.example.madrassaty.repositories.SchoolRepository;
import com.example.madrassaty.repositories.SpecialtyRepository;
import com.example.madrassaty.services.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;
    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;


    @Override
    public Specialty save(SpecialtyDTO specialtyDTO) throws NotFoundException {
        Specialty specialty = modelMapper.map(specialtyDTO, Specialty.class);
        specialty.setSchool(schoolRepository.findById(specialtyDTO.getSchoolId()).orElseThrow(() -> new NotFoundException("No school found")));
        return specialtyRepository.save(specialty);
    }

    @Override
    public Specialty update(SpecialtyDTO specialtyDTO) throws NotFoundException {
        if(specialtyRepository.findById(specialtyDTO.getId()).isPresent()) {
            Specialty specialty = modelMapper.map(specialtyDTO, Specialty.class);
            specialty.setSchool(schoolRepository.findById(specialtyDTO.getSchoolId()).orElseThrow(() -> new NotFoundException("No school found")));
            return specialtyRepository.save(specialty);
        }
        throw new NotFoundException("No specialty found");
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if(specialtyRepository.findById(id).isPresent()) {
            specialtyRepository.deleteById(id);
        }
        throw new NotFoundException("No specialty found");
    }

    @Override
    public Specialty findById(long id) throws NotFoundException {
        if(specialtyRepository.findById(id).isPresent()) {
            return specialtyRepository.findById(id).get();
        }
        throw new NotFoundException("No specialty found");
    }

    @Override
    public List<Specialty> findAllBySchoolId(long schoolId) {
        return specialtyRepository.findAllBySchoolId(schoolId);
    }
}
