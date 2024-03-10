package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.StudentRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.StudentAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/student")
public class StudentAuthController {

    private final StudentAuthService studentAuthService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequestDTO authRequestDTO) {
        return ResponseEntity.ok(studentAuthService.login(authRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @ModelAttribute StudentRegisterDTO studentRegisterDTO) throws NotFoundException, IOException {
        return ResponseEntity.ok(studentAuthService.register(studentRegisterDTO));
    }


}
