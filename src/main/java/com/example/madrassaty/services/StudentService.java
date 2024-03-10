package com.example.madrassaty.services;

import com.example.madrassaty.dtos.response.UserResponse;

import java.util.List;

public interface StudentService {

    List<UserResponse> findAllBySchoolId(long schoolId);
    List<UserResponse> findAllByClassId(long classId);

}
