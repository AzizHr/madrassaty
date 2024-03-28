package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.StudentYearDTO;
import com.example.madrassaty.dtos.response.StudentYearResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.StudentYearService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/student-year")
@RequiredArgsConstructor
public class StudentYearController {

    private final StudentYearService studentYearService;

    @PostMapping
    public ResponseEntity<StudentYearResponse> save(
            @Valid @RequestBody StudentYearDTO studentYearDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (studentYearService.save(studentYearDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StudentYearResponse> update(
            @Valid @RequestBody StudentYearDTO studentYearDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (studentYearService.update(studentYearDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentYearResponse> studentYear(
            @PathVariable UUID id)
            throws NotFoundException {
        return new ResponseEntity<>
                (studentYearService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id)
            throws NotFoundException {
        studentYearService.delete(id);
        return new ResponseEntity<>
                ("Student-Year with id"+id+"deleted with success", HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentYearResponse>> allByStudentId(
            @PathVariable UUID studentId) {
        return new ResponseEntity<>
                (studentYearService.findAllByStudentId(studentId), HttpStatus.OK);
    }

}
