package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.StudentYearDTO;
import com.example.madrassaty.dtos.response.StudentYearResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.StudentYear;
import com.example.madrassaty.repositories.StudentRepository;
import com.example.madrassaty.repositories.StudentYearRepository;
import com.example.madrassaty.repositories.YearRepository;
import com.example.madrassaty.services.StudentYearService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentYearServiceImpl implements StudentYearService {

    private final StudentYearRepository studentYearRepository;
    private final StudentRepository studentRepository;
    private final YearRepository yearRepository;
    private final ModelMapper modelMapper;

    @Override
    public StudentYearResponse save(StudentYearDTO studentYearDTO) throws NotFoundException {
        StudentYear studentYear = modelMapper.map(studentYearDTO, StudentYear.class);
        studentYear.setStudent(studentRepository
                .findById(studentYearDTO.getStudentId())
                .orElseThrow(() -> new NotFoundException("No student found")));
        studentYear.setYear(yearRepository
                .findById(studentYearDTO.getYearId())
                .orElseThrow(() -> new NotFoundException("No year found")));
        return modelMapper.map(studentYearRepository.save(studentYear), StudentYearResponse.class);
    }

    @Override
    public StudentYearResponse update(StudentYearDTO studentYearDTO) throws NotFoundException {
        if(studentYearRepository.findById(studentYearDTO.getId()).isPresent()) {
            StudentYear studentYear = modelMapper.map(studentYearDTO, StudentYear.class);
            studentYear.setStudent(studentRepository
                    .findById(studentYearDTO.getStudentId())
                    .orElseThrow(() -> new NotFoundException("No student found")));
            studentYear.setYear(yearRepository
                    .findById(studentYearDTO.getYearId())
                    .orElseThrow(() -> new NotFoundException("No year found")));
            return modelMapper.map(studentYearRepository.save(studentYear), StudentYearResponse.class);
        }
        throw new NotFoundException("No student-year found");
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if(studentYearRepository.findById(id).isPresent()) {
            studentYearRepository.deleteById(id);
        }
        throw new NotFoundException("No student-year found");
    }

    @Override
    public StudentYearResponse findById(long id) throws NotFoundException {
        if(studentYearRepository.findById(id).isPresent()) {
            return modelMapper.map(studentYearRepository.findById(id).get(), StudentYearResponse.class);
        }
        throw new NotFoundException("No student-year found");
    }

    @Override
    public List<StudentYearResponse> findAllByStudentId(long studentId) {
        List<StudentYear> studentYears = studentYearRepository.findAllByStudentId(studentId);
        return studentYears.stream()
                .map(studentYear -> modelMapper.map(studentYear, StudentYearResponse.class))
                .collect(Collectors.toList());
    }
}
