package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.SchoolDTO;
import com.example.madrassaty.dtos.response.SchoolResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    public ResponseEntity<SchoolResponse> save(
            @Valid @RequestBody SchoolDTO schoolDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (schoolService.save(schoolDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SchoolResponse> update(
            @Valid @RequestBody SchoolDTO schoolDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (schoolService.update(schoolDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolResponse> school(
            @PathVariable UUID id)
            throws NotFoundException {
        return new ResponseEntity<>
                (schoolService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/by/manager/{managerId}")
    public ResponseEntity<SchoolResponse> byManager(
            @PathVariable UUID managerId)
            throws NotFoundException {
        return new ResponseEntity<>
                (schoolService.findByManagerId(managerId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id)
            throws NotFoundException {
        schoolService.delete(id);
        return new ResponseEntity<>
                ("School with id"+id+"deleted with success", HttpStatus.OK);
    }

}
