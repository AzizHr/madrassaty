package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.AbsenceDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Absence;
import com.example.madrassaty.services.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/absences")
@RequiredArgsConstructor
public class AbsenceController {

    private final AbsenceService absenceService;

    @PostMapping
    public ResponseEntity<Absence> save(
            @RequestBody AbsenceDTO absenceDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (absenceService.save(absenceDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Absence> update(
            @RequestBody AbsenceDTO absenceDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (absenceService.update(absenceDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Absence> absence(
            @PathVariable long id)
            throws NotFoundException {
        return new ResponseEntity<>
                (absenceService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id)
            throws NotFoundException {
        absenceService.delete(id);
        return new ResponseEntity<>
                ("Absence with id"+id+"deleted with success", HttpStatus.OK);
    }

}
