package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.YearDTO;
import com.example.madrassaty.dtos.response.YearResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Year;
import com.example.madrassaty.repositories.SchoolRepository;
import com.example.madrassaty.repositories.YearRepository;
import com.example.madrassaty.services.YearService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class YearServiceImpl implements YearService {

    private final YearRepository yearRepository;
    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;

    @Override
    public YearResponse save(YearDTO yearDTO) throws NotFoundException {
        Year year = modelMapper.map(yearDTO, Year.class);
        year.setSchool(schoolRepository
                .findById(yearDTO.getSchoolId())
                .orElseThrow(() -> new NotFoundException("No school found")));
        return modelMapper.map(yearRepository.save(year), YearResponse.class);
    }

    @Override
    public YearResponse update(YearDTO yearDTO) throws NotFoundException {
        if(yearRepository.findById(yearDTO.getId()).isPresent()) {
            Year year = modelMapper.map(yearDTO, Year.class);
            year.setSchool(schoolRepository
                    .findById(yearDTO.getSchoolId())
                    .orElseThrow(() -> new NotFoundException("No school found")));
            return modelMapper.map(yearRepository.save(year), YearResponse.class);
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
    public YearResponse findById(long id) throws NotFoundException {
        if(yearRepository.findById(id).isPresent()) {
            return modelMapper.map(yearRepository.findById(id).get(), YearResponse.class);
        }
        throw new NotFoundException("No year found");
    }

    @Override
    public List<YearResponse> findAllBySchoolId(long schoolId) {
        List<Year> years = yearRepository.findAllBySchoolId(schoolId);
        return years.stream()
                .map(year -> modelMapper.map(year, YearResponse.class))
                .collect(Collectors.toList());
    }
}
