package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.SpecialtyDTO;
import com.example.madrassaty.dtos.response.SpecialtyResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Specialty;
import com.example.madrassaty.repositories.SchoolRepository;
import com.example.madrassaty.repositories.SpecialtyRepository;
import com.example.madrassaty.services.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;
    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;


    @Override
    public SpecialtyResponse save(SpecialtyDTO specialtyDTO) throws NotFoundException {
        Specialty specialty = modelMapper.map(specialtyDTO, Specialty.class);
        specialty.setSchool(schoolRepository.findById(specialtyDTO.getSchoolId()).orElseThrow(() -> new NotFoundException("No school found")));
        return modelMapper.map(specialtyRepository.save(specialty), SpecialtyResponse.class);
    }

    @Override
    public SpecialtyResponse update(SpecialtyDTO specialtyDTO) throws NotFoundException {
        if(specialtyRepository.findById(specialtyDTO.getId()).isPresent()) {
            Specialty specialty = modelMapper.map(specialtyDTO, Specialty.class);
            specialty.setSchool(schoolRepository.findById(specialtyDTO.getSchoolId()).orElseThrow(() -> new NotFoundException("No school found")));
            return modelMapper.map(specialtyRepository.save(specialty), SpecialtyResponse.class);
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
    public SpecialtyResponse findById(long id) throws NotFoundException {
        if(specialtyRepository.findById(id).isPresent()) {
            return modelMapper.map(specialtyRepository.findById(id).get(), SpecialtyResponse.class);
        }
        throw new NotFoundException("No specialty found");
    }

    @Override
    public List<SpecialtyResponse> findAllBySchoolId(long schoolId) {
        List<Specialty> specialties = specialtyRepository.findAllBySchoolId(schoolId);
        return specialties.stream()
                .map(specialty -> modelMapper.map(specialty, SpecialtyResponse.class))
                .collect(Collectors.toList());
    }
}
