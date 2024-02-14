package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.YearDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Year;
import com.example.madrassaty.repositories.SchoolRepository;
import com.example.madrassaty.repositories.YearRepository;
import com.example.madrassaty.services.YearService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class YearServiceImpl implements YearService {

    private final YearRepository yearRepository;
    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;

    @Override
    public Year save(YearDTO yearDTO) throws NotFoundException {
        Year year = modelMapper.map(yearDTO, Year.class);
        year.setSchool(schoolRepository
                .findById(yearDTO.getSchoolId())
                .orElseThrow(() -> new NotFoundException("No school found")));
        return yearRepository.save(year);
    }

    @Override
    public Year update(YearDTO yearDTO) throws NotFoundException {
        if(yearRepository.findById(yearDTO.getId()).isPresent()) {
            Year year = modelMapper.map(yearDTO, Year.class);
            year.setSchool(schoolRepository
                    .findById(yearDTO.getSchoolId())
                    .orElseThrow(() -> new NotFoundException("No school found")));
            return yearRepository.save(year);
        }
        throw new NotFoundException("No year found");
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if(yearRepository.findById(id).isPresent()) {
            yearRepository.deleteById(id);
        }
        throw new NotFoundException("No year found");
    }

    @Override
    public Year findById(long id) throws NotFoundException {
        if(yearRepository.findById(id).isPresent()) {
            return yearRepository.findById(id).get();
        }
        throw new NotFoundException("No year found");
    }

    @Override
    public List<Year> findAllBySchoolId(long schoolId) {
        return yearRepository.findAllBySchoolId(schoolId);
    }
}
