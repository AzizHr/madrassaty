package com.example.madrassaty.services;


import com.example.madrassaty.dtos.request.SchoolDTO;
import com.example.madrassaty.dtos.response.SchoolResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.School;

import java.util.UUID;

public interface SchoolService extends GlobalService<SchoolResponse, SchoolDTO> {
    SchoolResponse findByManagerId(UUID managerId) throws NotFoundException;
    SchoolResponse findByStudentId(UUID studentId);
    SchoolResponse findByTeacherId(UUID teacherId);
}
