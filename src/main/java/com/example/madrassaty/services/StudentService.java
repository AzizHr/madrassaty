package com.example.madrassaty.services;

import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    Page<UserResponse> findAllBySchoolId(long schoolId, Pageable pageable);
    Page<UserResponse> findAllByClassId(long classId, Pageable pageable);
}
