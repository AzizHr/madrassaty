package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.YearDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Year;
import com.example.madrassaty.services.YearService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class YearController {

    private final YearService yearService;


    @PostMapping
    public ResponseEntity<Year> save(
            @RequestBody YearDTO yearDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (yearService.save(yearDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Year> update(
            @RequestBody YearDTO yearDTO)
            throws NotFoundException {
        return new ResponseEntity<>
                (yearService.update(yearDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Year> specialty(
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

}
