package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.YearDTO;
import com.example.madrassaty.dtos.response.YearResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.YearService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/years")
@RequiredArgsConstructor
public class YearController {

    private final YearService yearService;

    @PostMapping
    public ResponseEntity<YearResponse> save(
            @Valid @RequestBody YearDTO yearDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (yearService.save(yearDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<YearResponse> update(
            @Valid @RequestBody YearDTO yearDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (yearService.update(yearDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<YearResponse> year(
            @PathVariable long id)
            throws NotFoundException {
        return new ResponseEntity<>
                (yearService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id)
            throws NotFoundException {
        yearService.delete(id);
        return new ResponseEntity<>
                ("Year with id"+id+"deleted with success", HttpStatus.OK);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<YearResponse>> allBySchoolId(@PathVariable long schoolId) {
        return new ResponseEntity<>
                (yearService.findAllBySchoolId(schoolId), HttpStatus.OK);
    }

}
