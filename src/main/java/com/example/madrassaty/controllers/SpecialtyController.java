package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.SpecialtyDTO;
import com.example.madrassaty.dtos.response.SpecialtyResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.SpecialtyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/specialties")
@RequiredArgsConstructor
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @PostMapping
    public ResponseEntity<SpecialtyResponse> save(
            @Valid @RequestBody SpecialtyDTO specialtyDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (specialtyService.save(specialtyDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SpecialtyResponse> update(
            @Valid @RequestBody SpecialtyDTO specialtyDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (specialtyService.update(specialtyDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialtyResponse> specialty(
            @PathVariable UUID id)
            throws NotFoundException {
        return new ResponseEntity<>
                (specialtyService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<?> allBySchoolId(
            @PathVariable UUID schoolId, Pageable pageable) {
        if(specialtyService.findAllBySchoolId(schoolId, pageable).isEmpty()) {
            return new ResponseEntity<>(Map.of("message", "No specialties found"), HttpStatus.OK);
        }
        return new ResponseEntity<>(specialtyService.findAllBySchoolId(schoolId, pageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id)
            throws NotFoundException {
        specialtyService.delete(id);
        return new ResponseEntity<>
                ("Specialty with id"+id+"deleted with success", HttpStatus.OK);
    }

}
