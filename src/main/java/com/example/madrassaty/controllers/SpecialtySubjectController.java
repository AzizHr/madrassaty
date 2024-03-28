package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.SpecialtySubjectDTO;
import com.example.madrassaty.exceptions.AlreadyAssignedException;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.SpecialtySubject;
import com.example.madrassaty.services.SpecialtySubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SpecialtySubjectController {

    private final SpecialtySubjectService specialtySubjectService;

    @PostMapping("/assign/subject/to/specialty")
    public ResponseEntity<SpecialtySubject> save(@Valid @RequestBody SpecialtySubjectDTO specialtySubjectDTO) throws AlreadyAssignedException {
        return ResponseEntity.ok(specialtySubjectService.save(specialtySubjectDTO));
    }

    @DeleteMapping("/remove/subject/from/specialty/{specialtyId}/{subjectId}")
    public ResponseEntity<Map<String, String>> delete(
            @PathVariable UUID specialtyId,
            @PathVariable UUID subjectId
    ) throws NotFoundException {
        specialtySubjectService.delete(specialtyId, subjectId);
        return ResponseEntity.ok(Map.of("message", "Subject unassigned with success"));
    }

}
