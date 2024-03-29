package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.StudentRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.dtos.response.RegisterResponse;

public interface StudentAuthService extends AuthService<AuthResponse, RegisterResponse, AuthRequestDTO, StudentRegisterDTO> {}
