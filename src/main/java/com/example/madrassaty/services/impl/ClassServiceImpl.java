package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.ClassDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Class;
import com.example.madrassaty.repositories.ClassRepository;
import com.example.madrassaty.services.ClassService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ClassServiceImpl implements ClassService {

    private ClassRepository classRepository;
    private ModelMapper modelMapper;

    @Override
    public Class save(ClassDTO classDTO) {
        Class aClass = modelMapper.map(classDTO, Class.class);
        return classRepository.save(aClass);
    }

    @Override
    public Class update(ClassDTO classDTO) throws NotFoundException {
        if(classRepository.findById(classDTO.getId()).isPresent()) {
            Class aClass = modelMapper.map(classDTO, Class.class);
            return classRepository.save(aClass);
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
    public Class findById(long id) throws NotFoundException {
        if(classRepository.findById(id).isPresent()) {
            return classRepository.findById(id).get();
        }
        throw new NotFoundException("No class found");
    }

    @Override
    public List<Class> findAll() {
        return classRepository.findAll();
    }

}
