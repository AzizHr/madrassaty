package com.example.madrassaty.services;


import com.example.madrassaty.dtos.request.SchoolDTO;
import com.example.madrassaty.dtos.response.SchoolResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.School;

public interface SchoolService extends GlobalService<SchoolResponse, SchoolDTO> {
    SchoolResponse findByManagerId(long managerId) throws NotFoundException;
}
