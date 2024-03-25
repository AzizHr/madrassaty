package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.ClassDTO;
import com.example.madrassaty.dtos.response.ClassResponse;
import com.example.madrassaty.models.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClassService extends GlobalService<ClassResponse, ClassDTO> {
    List<ClassResponse> findAll();
    Page<ClassResponse> findAllBySchoolId(long schoolId, Pageable pageable);
    Page<ClassResponse> findAllByTeacherId(long teacherId, Pageable pageable);
}
