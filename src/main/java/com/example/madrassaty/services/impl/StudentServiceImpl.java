package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.response.ProfileResponse;
import com.example.madrassaty.dtos.response.StudentResponse;
import com.example.madrassaty.models.Student;
import com.example.madrassaty.repositories.ClassRepository;
import com.example.madrassaty.repositories.StudentRepository;
import com.example.madrassaty.services.StudentService;
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
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<StudentResponse> findAllBySchoolId(UUID schoolId, Pageable pageable) {
        Page<Student> studentPage = studentRepository.findAllBySchoolId(schoolId, pageable);

        return new PageImpl<>(
                studentPage.getContent().stream()
                        .map(student -> modelMapper.map(student, StudentResponse.class))
                        .collect(Collectors.toList()),
                studentPage.getPageable(),
                studentPage.getTotalElements()
        );
    }

    @Override
    public Page<StudentResponse> findAllByClassId(UUID classId, Pageable pageable) {
        Page<Student> studentPage = studentRepository.findAllBy_class_Id(classId, pageable);

        return new PageImpl<>(
                studentPage.getContent().stream()
                        .map(student -> modelMapper.map(student, StudentResponse.class))
                        .collect(Collectors.toList()),
                studentPage.getPageable(),
                studentPage.getTotalElements()
        );
    }
}
