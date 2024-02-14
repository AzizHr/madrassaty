package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.TeacherRegisterDTO;
import com.example.madrassaty.dtos.response.JwtResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.TeacherAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/teacher")
public class TeacherAuthController {

    private final TeacherAuthService teacherAuthService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthRequestDTO authRequestDTO) {
        return ResponseEntity.ok(teacherAuthService.login(authRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody TeacherRegisterDTO teacherRegisterDTO) throws NotFoundException {
        return ResponseEntity.ok(teacherAuthService.register(teacherRegisterDTO));
    }

}
