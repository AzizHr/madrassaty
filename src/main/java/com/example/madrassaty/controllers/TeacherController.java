package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<UserResponse>> allBySchoolId(@PathVariable long schoolId) {
        return ResponseEntity.ok(teacherService.findAllBySchoolId(schoolId));
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<List<UserResponse>> allByClassId(@PathVariable long classId) {
        return ResponseEntity.ok(teacherService.findAllByClassId(classId));
    }

}
