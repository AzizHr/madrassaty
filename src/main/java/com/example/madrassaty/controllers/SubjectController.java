package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.SubjectDTO;
import com.example.madrassaty.dtos.response.SubjectResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectResponse> save(
            @Valid @RequestBody SubjectDTO subjectDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (subjectService.save(subjectDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SubjectResponse> update(
            @Valid @RequestBody SubjectDTO subjectDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (subjectService.update(subjectDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponse> subject(
            @PathVariable UUID id)
            throws NotFoundException {
        return new ResponseEntity<>
                (subjectService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id)
            throws NotFoundException {
        subjectService.delete(id);
        return new ResponseEntity<>
                ("Subject with id"+id+"deleted with success", HttpStatus.OK);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<?> allBySchoolId(@PathVariable UUID schoolId, Pageable pageable) {
        if(subjectService.findAllBySchoolId(schoolId, pageable).isEmpty()) {
            return new ResponseEntity<>(Map.of("message", "No subjects found"), HttpStatus.OK);
        }
        return new ResponseEntity<>(subjectService.findAllBySchoolId(schoolId, pageable), HttpStatus.OK);
    }
}
