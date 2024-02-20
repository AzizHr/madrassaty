package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.ManagerRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.ManagerAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/manager")
public class ManagerAuthController {

    private final ManagerAuthService managerAuthService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequestDTO authRequestDTO) {
        return ResponseEntity.ok(managerAuthService.login(authRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@ModelAttribute ManagerRegisterDTO managerRegisterDTO) throws NotFoundException, IOException {
        return ResponseEntity.ok(managerAuthService.register(managerRegisterDTO));
    }

}
