package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.ClassDTO;
import com.example.madrassaty.dtos.response.ClassResponse;
import com.example.madrassaty.dtos.response.SchoolResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Class;
import com.example.madrassaty.repositories.ClassRepository;
import com.example.madrassaty.repositories.SchoolRepository;
import com.example.madrassaty.services.ClassService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClassServiceImpl implements ClassService {

    private ClassRepository classRepository;
    private SchoolRepository schoolRepository;
    private ModelMapper modelMapper;

    @Override
    public ClassResponse save(ClassDTO classDTO) throws NotFoundException {
        Class aClass = modelMapper.map(classDTO, Class.class);
        aClass.setSchool(schoolRepository.findById(classDTO.getSchoolId())
                .orElseThrow(() -> new NotFoundException("No school found")));
        return modelMapper.map(classRepository.save(aClass), ClassResponse.class);
    }

    @Override
    public ClassResponse update(ClassDTO classDTO) throws NotFoundException {
        if(classRepository.findById(classDTO.getId()).isPresent()) {
            Class aClass = modelMapper.map(classDTO, Class.class);
            return modelMapper.map(classRepository.save(aClass), ClassResponse.class);
        }
        throw new NotFoundException("No class found");
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if(classRepository.findById(id).isPresent()) {
            classRepository.deleteById(id);
        }
        throw new NotFoundException("No class found");
    }

    @Override
    public ClassResponse findById(long id) throws NotFoundException {
        if(classRepository.findById(id).isPresent()) {
            return modelMapper.map(classRepository.findById(id).get(), ClassResponse.class);
        }
        throw new NotFoundException("No class found");
    }

    @Override
    public List<ClassResponse> findAll() {
        List<Class> classes = classRepository.findAll();
        return classes.stream()
                .map(aClass -> modelMapper.map(aClass, ClassResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ClassResponse> findAllBySchoolId(long schoolId, Pageable pageable) {
        Page<Class> classPage = classRepository.findAllBySchoolId(schoolId, pageable);

        return new PageImpl<>(
                classPage.getContent().stream()
                        .map(aClass -> modelMapper.map(aClass, ClassResponse.class))
                        .collect(Collectors.toList()),
                classPage.getPageable(),
                classPage.getTotalElements()
        );
    }

    @Override
    public Page<ClassResponse> findAllByTeacherId(long teacherId, Pageable pageable) {
        Page<Class> classPage = classRepository.findAllByTeacherId(teacherId, pageable);

        return new PageImpl<>(
                classPage.getContent().stream()
                        .map(aClass -> modelMapper.map(aClass, ClassResponse.class))
                        .collect(Collectors.toList()),
                classPage.getPageable(),
                classPage.getTotalElements()
        );
    }

}
