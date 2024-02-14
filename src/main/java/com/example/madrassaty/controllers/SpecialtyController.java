package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.SpecialtyDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Specialty;
import com.example.madrassaty.services.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/specialties")
@RequiredArgsConstructor
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @PostMapping
    public ResponseEntity<Specialty> save(
            @RequestBody SpecialtyDTO specialtyDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (specialtyService.save(specialtyDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Specialty> update(
            @RequestBody SpecialtyDTO specialtyDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (specialtyService.update(specialtyDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialty> specialty(
            @PathVariable long id)
            throws NotFoundException {
        return new ResponseEntity<>
                (specialtyService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id)
            throws NotFoundException {
        specialtyService.delete(id);
        return new ResponseEntity<>
                ("Specialty with id"+id+"deleted with success", HttpStatus.OK);
    }

}
