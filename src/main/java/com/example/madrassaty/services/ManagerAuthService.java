package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.ManagerRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.dtos.response.RegisterResponse;

public interface ManagerAuthService extends AuthService<AuthResponse, RegisterResponse, AuthRequestDTO, ManagerRegisterDTO> {}
