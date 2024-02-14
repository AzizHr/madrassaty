package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.StudentRegisterDTO;
import com.example.madrassaty.dtos.response.JwtResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.StudentAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/student")
public class StudentAuthController {

    private final StudentAuthService studentAuthService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthRequestDTO authRequestDTO) {
        return ResponseEntity.ok(studentAuthService.login(authRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody StudentRegisterDTO studentRegisterDTO) throws NotFoundException {
        return ResponseEntity.ok(studentAuthService.register(studentRegisterDTO));
    }

}
