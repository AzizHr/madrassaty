package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.ManagerRegisterDTO;
import com.example.madrassaty.dtos.response.JwtResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.ManagerAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/manager")
public class ManagerAuthController {

    private final ManagerAuthService managerAuthService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthRequestDTO authRequestDTO) {
        return ResponseEntity.ok(managerAuthService.login(authRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody ManagerRegisterDTO managerRegisterDTO) throws NotFoundException {
        return ResponseEntity.ok(managerAuthService.register(managerRegisterDTO));
    }

}
