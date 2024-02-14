package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.YearDTO;
import com.example.madrassaty.models.Year;
import java.util.List;

public interface YearService extends GlobalService<Year, YearDTO> {
    List<Year> findAllBySchoolId(long schoolId);
}
