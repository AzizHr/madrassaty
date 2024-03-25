package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.TeacherClassDTO;
import com.example.madrassaty.exceptions.AlreadyAssignedException;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.TeacherClass;
import com.example.madrassaty.services.TeacherClassService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TeacherClassController {

    private final TeacherClassService teacherClassService;

    @PostMapping("/assign/teacher/to/class")
    public ResponseEntity<TeacherClass> save(@RequestBody @Valid TeacherClassDTO teacherClassDTO) throws AlreadyAssignedException {
        return ResponseEntity.ok(teacherClassService.save(teacherClassDTO));
    }

    @DeleteMapping("/remove/teacher/from/class/{teacherId}/{classId}")
    public ResponseEntity<Map<String, String>> delete(
            @PathVariable long teacherId,
            @PathVariable long classId
    ) throws NotFoundException {
        teacherClassService.delete(teacherId, classId);
        return ResponseEntity.ok(Map.of("message", "Teacher unassigned with success"));
    }

}
