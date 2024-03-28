package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.TeacherClassDTO;
import com.example.madrassaty.exceptions.AlreadyAssignedException;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.TeacherClass;
import com.example.madrassaty.models.embeddables.TeacherClassId;

import java.util.UUID;

public interface TeacherClassService {
    TeacherClass save(TeacherClassDTO teacherClassDTO) throws AlreadyAssignedException;
    TeacherClass update(TeacherClassDTO teacherClassDTO) throws NotFoundException;
    void delete(UUID teacherId, UUID classId) throws NotFoundException;
    TeacherClass findById(TeacherClassId id) throws NotFoundException;
}
