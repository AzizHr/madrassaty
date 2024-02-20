package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.StudentRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.StudentAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/student")
public class StudentAuthController {

    private final StudentAuthService studentAuthService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequestDTO authRequestDTO) {
        return ResponseEntity.ok(studentAuthService.login(authRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody StudentRegisterDTO studentRegisterDTO) throws NotFoundException, IOException {
        return ResponseEntity.ok(studentAuthService.register(studentRegisterDTO));
    }

}
