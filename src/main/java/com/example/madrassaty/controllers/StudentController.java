package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<UserResponse>> allBySchoolId(@PathVariable long schoolId) {
        return ResponseEntity.ok(studentService.findAllBySchoolId(schoolId));
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<List<UserResponse>> allByClassId(@PathVariable long classId) {
        return ResponseEntity.ok(studentService.findAllByClassId(classId));
    }
}
