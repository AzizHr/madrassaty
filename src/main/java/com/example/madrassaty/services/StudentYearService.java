package com.example.madrassaty.services;


import com.example.madrassaty.dtos.request.StudentYearDTO;
import com.example.madrassaty.dtos.response.StudentYearResponse;
import com.example.madrassaty.models.Student;
import com.example.madrassaty.models.StudentYear;

import java.util.List;

public interface StudentYearService extends GlobalService<StudentYearResponse, StudentYearDTO> {
    List<StudentYearResponse> findAllByStudentId(long studentId);
}
