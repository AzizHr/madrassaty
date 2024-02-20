package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.TeacherRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;

public interface TeacherAuthService extends AuthService<AuthResponse, AuthRequestDTO, TeacherRegisterDTO> {}
