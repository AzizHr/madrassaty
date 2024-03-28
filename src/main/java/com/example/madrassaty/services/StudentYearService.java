package com.example.madrassaty.services;


import com.example.madrassaty.dtos.request.StudentYearDTO;
import com.example.madrassaty.dtos.response.StudentYearResponse;
import com.example.madrassaty.models.Student;
import com.example.madrassaty.models.StudentYear;

import java.util.List;
import java.util.UUID;

public interface StudentYearService extends GlobalService<StudentYearResponse, StudentYearDTO> {
    List<StudentYearResponse> findAllByStudentId(UUID studentId);
}
