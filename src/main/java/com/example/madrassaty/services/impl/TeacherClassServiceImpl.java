package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.TeacherClassDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.TeacherClass;
import com.example.madrassaty.models.embeddables.TeacherClassId;
import com.example.madrassaty.repositories.TeacherClassRepository;
import com.example.madrassaty.services.TeacherClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherClassServiceImpl implements TeacherClassService {

    private final TeacherClassRepository teacherClassRepository;

    @Override
    public TeacherClass save(TeacherClassDTO teacherClassDTO) {
        TeacherClassId teacherClassId = new TeacherClassId();
        teacherClassId.setTeacherId(teacherClassDTO.getTeacherId());
        teacherClassId.setClassId(teacherClassDTO.getClassId());
        TeacherClass teacherClass = new TeacherClass();
        teacherClass.setId(teacherClassId);
        return teacherClassRepository.save(teacherClass);
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
    public void delete(long teacherId, long classId) throws NotFoundException {
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
