package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.AbsenceDTO;
import com.example.madrassaty.dtos.response.AbsenceResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.AbsenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/absences")
@RequiredArgsConstructor
public class AbsenceController {

    private final AbsenceService absenceService;

    @PostMapping
    public ResponseEntity<AbsenceResponse> save(
            @Valid @RequestBody AbsenceDTO absenceDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (absenceService.save(absenceDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AbsenceResponse> update(
            @Valid @RequestBody AbsenceDTO absenceDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (absenceService.update(absenceDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbsenceResponse> absence(
            @PathVariable UUID id)
            throws NotFoundException {
        return new ResponseEntity<>
                (absenceService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id)
            throws NotFoundException {
        absenceService.delete(id);
        return new ResponseEntity<>
                ("Absence with id"+id+"deleted with success", HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AbsenceResponse>> allByStudentId(@PathVariable UUID studentId) {
        return new ResponseEntity<>
                (absenceService.findAllByStudentId(studentId), HttpStatus.OK);
    }

}
