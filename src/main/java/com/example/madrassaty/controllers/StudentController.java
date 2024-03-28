package com.example.madrassaty.controllers;

import com.example.madrassaty.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<?> allBySchoolId(@PathVariable UUID schoolId, Pageable pageable) {
        if(studentService.findAllBySchoolId(schoolId, pageable).isEmpty()) {
            return new ResponseEntity<>(Map.of("message", "No students found"), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentService.findAllBySchoolId(schoolId, pageable), HttpStatus.OK);
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<?> allByClassId(@PathVariable UUID classId, Pageable pageable) {
        if(studentService.findAllByClassId(classId, pageable).isEmpty()) {
            return new ResponseEntity<>(Map.of("message", "No students found"), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentService.findAllByClassId(classId, pageable), HttpStatus.OK);
    }
}
