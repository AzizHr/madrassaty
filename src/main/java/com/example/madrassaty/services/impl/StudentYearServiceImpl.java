package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.StudentYearDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.StudentYear;
import com.example.madrassaty.repositories.StudentRepository;
import com.example.madrassaty.repositories.StudentYearRepository;
import com.example.madrassaty.repositories.YearRepository;
import com.example.madrassaty.services.StudentYearService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentYearServiceImpl implements StudentYearService {

    private final StudentYearRepository studentYearRepository;
    private final StudentRepository studentRepository;
    private final YearRepository yearRepository;
    private final ModelMapper modelMapper;

    @Override
    public StudentYear save(StudentYearDTO studentYearDTO) throws NotFoundException {
        StudentYear studentYear = modelMapper.map(studentYearDTO, StudentYear.class);
        studentYear.setStudent(studentRepository
                .findById(studentYearDTO.getStudentId())
                .orElseThrow(() -> new NotFoundException("No student found")));
        studentYear.setYear(yearRepository
                .findById(studentYearDTO.getYearId())
                .orElseThrow(() -> new NotFoundException("No year found")));
        return studentYearRepository.save(studentYear);
    }

    @Override
    public StudentYear update(StudentYearDTO studentYearDTO) throws NotFoundException {
        if(studentYearRepository.findById(studentYearDTO.getId()).isPresent()) {
            StudentYear studentYear = modelMapper.map(studentYearDTO, StudentYear.class);
            studentYear.setStudent(studentRepository
                    .findById(studentYearDTO.getStudentId())
                    .orElseThrow(() -> new NotFoundException("No student found")));
            studentYear.setYear(yearRepository
                    .findById(studentYearDTO.getYearId())
                    .orElseThrow(() -> new NotFoundException("No year found")));
            return studentYearRepository.save(studentYear);
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
    public StudentYear findById(long id) throws NotFoundException {
        if(studentYearRepository.findById(id).isPresent()) {
            return studentYearRepository.findById(id).get();
        }
        throw new NotFoundException("No student-year found");
    }
}
