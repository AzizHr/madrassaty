package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.ClassDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Class;
import com.example.madrassaty.services.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;


    @PostMapping
    public ResponseEntity<Class> save(
            @RequestBody ClassDTO classDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (classService.save(classDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Class> update(
            @RequestBody ClassDTO classDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (classService.update(classDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Class> aClass(
            @PathVariable long id)
            throws NotFoundException {
        return new ResponseEntity<>
                (classService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id)
            throws NotFoundException {
        classService.delete(id);
        return new ResponseEntity<>
                ("Class with id"+id+"deleted with success", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Class>> classes() {
        return new ResponseEntity<>
                (classService.findAll(), HttpStatus.OK);
    }
}
