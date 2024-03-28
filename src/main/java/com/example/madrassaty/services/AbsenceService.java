package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.AbsenceDTO;
import com.example.madrassaty.dtos.response.AbsenceResponse;
import com.example.madrassaty.models.Absence;

import java.util.List;
import java.util.UUID;

public interface AbsenceService extends GlobalService<AbsenceResponse, AbsenceDTO> {
    List<AbsenceResponse> findAllByStudentId(UUID studentId);
}
