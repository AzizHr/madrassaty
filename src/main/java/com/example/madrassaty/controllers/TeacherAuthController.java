package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.TeacherRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.TeacherAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/teacher")
public class TeacherAuthController {

    private final TeacherAuthService teacherAuthService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequestDTO authRequestDTO) {
        return ResponseEntity.ok(teacherAuthService.login(authRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody TeacherRegisterDTO teacherRegisterDTO) throws NotFoundException, IOException {
        return ResponseEntity.ok(teacherAuthService.register(teacherRegisterDTO));
    }

}
