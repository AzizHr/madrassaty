package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.ClassDTO;
import com.example.madrassaty.dtos.response.ClassResponse;
import com.example.madrassaty.models.Class;

import java.util.List;

public interface ClassService extends GlobalService<ClassResponse, ClassDTO> {
    List<ClassResponse> findAll();
    List<ClassResponse> findAllBySchoolId(long schoolId);
    List<ClassResponse> findAllByTeacherId(long teacherId);
}
