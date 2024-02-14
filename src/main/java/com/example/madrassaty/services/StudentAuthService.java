package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.StudentRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.dtos.response.JwtResponse;

public interface StudentAuthService extends AuthService<JwtResponse, AuthRequestDTO, StudentRegisterDTO> {}
