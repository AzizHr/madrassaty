package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.TeacherRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.exceptions.EmailAlreadyInUseException;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.TeacherAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/teacher")
public class TeacherAuthController {

    private final TeacherAuthService teacherAuthService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequestDTO authRequestDTO) {
        return ResponseEntity.ok(teacherAuthService.login(authRequestDTO));
    }

    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AuthResponse> register(@Valid @ModelAttribute TeacherRegisterDTO teacherRegisterDTO) throws NotFoundException, IOException, EmailAlreadyInUseException {
        return ResponseEntity.ok(teacherAuthService.register(teacherRegisterDTO));
    }

}
