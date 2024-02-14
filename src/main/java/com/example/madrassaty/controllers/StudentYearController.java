package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.StudentYearDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.StudentYear;
import com.example.madrassaty.services.StudentYearService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student-year")
@RequiredArgsConstructor
public class StudentYearController {

    private final StudentYearService studentYearService;

    @PostMapping
    public ResponseEntity<StudentYear> save(
            @RequestBody StudentYearDTO studentYearDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (studentYearService.save(studentYearDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StudentYear> update(
            @RequestBody StudentYearDTO studentYearDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (studentYearService.update(studentYearDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentYear> studentYear(
            @PathVariable long id)
            throws NotFoundException {
        return new ResponseEntity<>
                (studentYearService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id)
            throws NotFoundException {
        studentYearService.delete(id);
        return new ResponseEntity<>
                ("Student-Year with id"+id+"deleted with success", HttpStatus.OK);
    }

}
