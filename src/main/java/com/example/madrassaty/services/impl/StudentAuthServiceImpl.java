package com.example.madrassaty.services.impl;

import com.example.madrassaty.authenticators.StudentAuthenticator;
import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.StudentRegisterDTO;
import com.example.madrassaty.dtos.response.JwtResponse;
import com.example.madrassaty.enums.Role;
import com.example.madrassaty.models.Student;
import com.example.madrassaty.repositories.StudentRepository;
import com.example.madrassaty.services.StudentAuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentAuthServiceImpl implements StudentAuthService {

    private final StudentDetailsService studentDetailsService;
    private final StudentRepository studentRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    @Override
    public JwtResponse login(AuthRequestDTO authRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDTO.getEmail(),
                        authRequestDTO.getPassword()
                )
        );

        UserDetails student = studentDetailsService.loadUserByUsername(authRequestDTO.getEmail());
        String jwtToken = jwtService.generateToken(student);
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(jwtToken);
        return jwtResponse;
    }

    @Override
    public JwtResponse register(StudentRegisterDTO studentRegisterDTO) {
        Student student = modelMapper.map(studentRegisterDTO, Student.class);
        student.setRole(Role.STUDENT);
        student.setPassword(passwordEncoder.encode(studentRegisterDTO.getPassword()));
        studentRepository.save(student);
        StudentAuthenticator studentAuthenticator = new StudentAuthenticator(student);
        String jwtToken = jwtService.generateToken(studentAuthenticator);
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(jwtToken);
        return jwtResponse;
    }
}
