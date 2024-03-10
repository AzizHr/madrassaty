package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.models.Student;
import com.example.madrassaty.models.Teacher;
import com.example.madrassaty.repositories.TeacherRepository;
import com.example.madrassaty.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserResponse> findAllBySchoolId(long schoolId) {
        List<Teacher> teachers = teacherRepository.findAllBySchoolId(schoolId);
        return teachers.stream()
                .map(teacher -> modelMapper.map(teacher, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResponse> findAllByClassId(long classId) {
        List<Teacher> teachers = teacherRepository.findAllByClassId(classId);
        return teachers.stream()
                .map(teacher -> modelMapper.map(teacher, UserResponse.class))
                .collect(Collectors.toList());
    }
}
