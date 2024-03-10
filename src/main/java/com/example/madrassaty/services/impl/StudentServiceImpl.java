package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.models.Student;
import com.example.madrassaty.repositories.StudentRepository;
import com.example.madrassaty.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserResponse> findAllBySchoolId(long schoolId) {
        List<Student> students = studentRepository.findAllBySchoolId(schoolId);
        return students.stream()
                .map(student -> modelMapper.map(student, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResponse> findAllByClassId(long classId) {
        List<Student> students = studentRepository.findAllBy_class_Id(classId);
        return students.stream()
                .map(student -> modelMapper.map(student, UserResponse.class))
                .collect(Collectors.toList());
    }
}
