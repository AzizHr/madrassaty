package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.TeacherRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.dtos.response.JwtResponse;

public interface TeacherAuthService extends AuthService<JwtResponse, AuthRequestDTO, TeacherRegisterDTO> {}
