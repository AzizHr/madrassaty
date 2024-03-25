package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.response.ClassResponse;
import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Class;
import com.example.madrassaty.models.Student;
import com.example.madrassaty.models.User;
import com.example.madrassaty.repositories.ClassRepository;
import com.example.madrassaty.repositories.StudentRepository;
import com.example.madrassaty.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<UserResponse> findAllBySchoolId(long schoolId, Pageable pageable) {
        Page<Student> studentPage = studentRepository.findAllBySchoolId(schoolId, pageable);

        return new PageImpl<>(
                studentPage.getContent().stream()
                        .map(student -> modelMapper.map(student, UserResponse.class))
                        .collect(Collectors.toList()),
                studentPage.getPageable(),
                studentPage.getTotalElements()
        );
    }

    @Override
    public Page<UserResponse> findAllByClassId(long classId, Pageable pageable) {
        Page<Student> studentPage = studentRepository.findAllBy_class_Id(classId, pageable);

        return new PageImpl<>(
                studentPage.getContent().stream()
                        .map(student -> modelMapper.map(student, UserResponse.class))
                        .collect(Collectors.toList()),
                studentPage.getPageable(),
                studentPage.getTotalElements()
        );
    }
}
