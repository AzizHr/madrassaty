package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.response.TeacherResponse;
import com.example.madrassaty.models.Teacher;
import com.example.madrassaty.repositories.TeacherRepository;
import com.example.madrassaty.services.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<TeacherResponse> findAllBySchoolId(UUID schoolId, Pageable pageable) {
        Page<Teacher> teacherPage = teacherRepository.findAllBySchoolId(schoolId, pageable);

        return new PageImpl<>(
                teacherPage.getContent().stream()
                        .map(teacher -> modelMapper.map(teacher, TeacherResponse.class))
                        .collect(Collectors.toList()),
                teacherPage.getPageable(),
                teacherPage.getTotalElements()
        );
    }

    @Override
    public Page<TeacherResponse> findAllByClassId(UUID classId, Pageable pageable) {
        Page<Teacher> teacherPage = teacherRepository.findAllByClassId(classId, pageable);

        return new PageImpl<>(
                teacherPage.getContent().stream()
                        .map(teacher -> modelMapper.map(teacher, TeacherResponse.class))
                        .collect(Collectors.toList()),
                teacherPage.getPageable(),
                teacherPage.getTotalElements()
        );
    }
}
