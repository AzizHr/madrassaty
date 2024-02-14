package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.ClassDTO;
import com.example.madrassaty.models.Class;
import java.util.List;

public interface ClassService extends GlobalService<Class, ClassDTO> {
    List<Class> findAll();
}
