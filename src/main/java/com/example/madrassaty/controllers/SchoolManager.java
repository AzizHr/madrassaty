package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.SchoolDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.School;
import com.example.madrassaty.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schools")
@RequiredArgsConstructor
public class SchoolManager {

    private final SchoolService schoolService;

    @PostMapping
    public ResponseEntity<School> save(
            @RequestBody SchoolDTO schoolDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (schoolService.save(schoolDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<School> update(
            @RequestBody SchoolDTO schoolDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (schoolService.update(schoolDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> school(
            @PathVariable long id)
            throws NotFoundException {
        return new ResponseEntity<>
                (schoolService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id)
            throws NotFoundException {
        schoolService.delete(id);
        return new ResponseEntity<>
                ("School with id"+id+"deleted with success", HttpStatus.OK);
    }

}
