package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.models.Student;
import com.example.madrassaty.models.Teacher;
import com.example.madrassaty.repositories.TeacherRepository;
import com.example.madrassaty.services.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<UserResponse> findAllBySchoolId(long schoolId, Pageable pageable) {
        Page<Teacher> teacherPage = teacherRepository.findAllBySchoolId(schoolId, pageable);

        return new PageImpl<>(
                teacherPage.getContent().stream()
                        .map(teacher -> modelMapper.map(teacher, UserResponse.class))
                        .collect(Collectors.toList()),
                teacherPage.getPageable(),
                teacherPage.getTotalElements()
        );
    }

    @Override
    public Page<UserResponse> findAllByClassId(long classId, Pageable pageable) {
        Page<Teacher> teacherPage = teacherRepository.findAllByClassId(classId, pageable);

        return new PageImpl<>(
                teacherPage.getContent().stream()
                        .map(teacher -> modelMapper.map(teacher, UserResponse.class))
                        .collect(Collectors.toList()),
                teacherPage.getPageable(),
                teacherPage.getTotalElements()
        );
    }
}
