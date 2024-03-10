package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.YearDTO;
import com.example.madrassaty.dtos.response.YearResponse;
import com.example.madrassaty.models.Year;
import java.util.List;

public interface YearService extends GlobalService<YearResponse, YearDTO> {
    List<YearResponse> findAllBySchoolId(long schoolId);
}
