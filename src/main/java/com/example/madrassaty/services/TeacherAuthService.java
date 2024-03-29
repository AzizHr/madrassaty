package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.TeacherRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.dtos.response.RegisterResponse;

public interface TeacherAuthService extends AuthService<AuthResponse, RegisterResponse, AuthRequestDTO, TeacherRegisterDTO> {}
