package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.TeacherClassDTO;
import com.example.madrassaty.exceptions.AlreadyAssignedException;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.TeacherClass;
import com.example.madrassaty.models.embeddables.TeacherClassId;
import com.example.madrassaty.repositories.TeacherClassRepository;
import com.example.madrassaty.services.TeacherClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherClassServiceImpl implements TeacherClassService {

    private final TeacherClassRepository teacherClassRepository;

    @Override
    public TeacherClass save(TeacherClassDTO teacherClassDTO) throws AlreadyAssignedException {
        TeacherClassId teacherClassId = new TeacherClassId();
        teacherClassId.setTeacherId(teacherClassDTO.getTeacherId());
        teacherClassId.setClassId(teacherClassDTO.getClassId());
        if(teacherClassRepository.findById(teacherClassId).isPresent()) {
            throw new AlreadyAssignedException("This teacher is already assigned to this class");
        } else {
            TeacherClass teacherClass = new TeacherClass();
            teacherClass.setId(teacherClassId);
            return teacherClassRepository.save(teacherClass);
        }
    }

    @Override
    public TeacherClass update(TeacherClassDTO teacherClassDTO) throws NotFoundException {
        TeacherClassId teacherClassId = new TeacherClassId();
        teacherClassId.setTeacherId(teacherClassDTO.getTeacherId());
        teacherClassId.setClassId(teacherClassDTO.getClassId());
        if(teacherClassRepository.findById(teacherClassId).isPresent()) {
            TeacherClass teacherClass = new TeacherClass();
            teacherClass.setId(teacherClassId);
            return teacherClassRepository.save(teacherClass);
        }
        throw new NotFoundException("No teacher-class found");
    }

    @Override
    public void delete(UUID teacherId, UUID classId) throws NotFoundException {
        TeacherClassId teacherClassId = new TeacherClassId();
        teacherClassId.setTeacherId(teacherId);
        teacherClassId.setClassId(classId);
        if(teacherClassRepository.findById(teacherClassId).isPresent()) {
            teacherClassRepository.deleteById(teacherClassId);
            return;
        }
        throw new NotFoundException("No teacher-class found");
    }

    @Override
    public TeacherClass findById(TeacherClassId id) throws NotFoundException {
        return null;
    }
}
