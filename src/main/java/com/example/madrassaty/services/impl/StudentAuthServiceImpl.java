package com.example.madrassaty.services.impl;

import com.example.madrassaty.security.authenticators.StudentAuthenticator;
import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.StudentRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.enums.Role;
import com.example.madrassaty.models.Student;
import com.example.madrassaty.repositories.StudentRepository;
import com.example.madrassaty.services.CloudinaryService;
import com.example.madrassaty.services.StudentAuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class StudentAuthServiceImpl implements StudentAuthService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;

    @Override
    public AuthResponse login(AuthRequestDTO authRequestDTO) {

        Student student = studentRepository.findStudentByEmail(authRequestDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Email or password not valid"));

        StudentAuthenticator studentAuthenticator = new StudentAuthenticator(student);
        String jwtToken = jwtService.generateToken(studentAuthenticator);
        AuthResponse authResponse = modelMapper.map(student, AuthResponse.class);
        authResponse.setToken(jwtToken);
        return authResponse;
    }

    @Override
    public AuthResponse register(StudentRegisterDTO studentRegisterDTO) throws IOException {
        Student student = modelMapper.map(studentRegisterDTO, Student.class);
        student.setRole(Role.STUDENT);
        student.setPassword(passwordEncoder.encode(studentRegisterDTO.getPassword()));
        if (studentRegisterDTO.getImage() != null) {
            String imageUrl = cloudinaryService.uploadFile(studentRegisterDTO.getImage());
            student.setImage(imageUrl);
        }
        studentRepository.save(student);
        StudentAuthenticator studentAuthenticator = new StudentAuthenticator(student);
        String jwtToken = jwtService.generateToken(studentAuthenticator);
        AuthResponse authResponse = modelMapper.map(student, AuthResponse.class);
        authResponse.setToken(jwtToken);
        return authResponse;
    }
}
