package com.example.madrassaty.services.impl;

import com.example.madrassaty.authenticators.TeacherAuthenticator;
import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.TeacherRegisterDTO;
import com.example.madrassaty.dtos.response.JwtResponse;
import com.example.madrassaty.enums.Role;
import com.example.madrassaty.models.Teacher;
import com.example.madrassaty.repositories.TeacherRepository;
import com.example.madrassaty.services.TeacherAuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherAuthServiceImpl implements TeacherAuthService {

    private final TeacherDetailsService teacherDetailsService;
    private final TeacherRepository teacherRepository;
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

        UserDetails teacher = teacherDetailsService.loadUserByUsername(authRequestDTO.getEmail());
        String jwtToken = jwtService.generateToken(teacher);
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(jwtToken);
        return jwtResponse;
    }

    @Override
    public JwtResponse register(TeacherRegisterDTO teacherRegisterDTO) {
        Teacher teacher = modelMapper.map(teacherRegisterDTO, Teacher.class);
        teacher.setRole(Role.TEACHER);
        teacher.setPassword(passwordEncoder.encode(teacherRegisterDTO.getPassword()));
        teacherRepository.save(teacher);
        TeacherAuthenticator teacherAuthenticator = new TeacherAuthenticator(teacher);
        String jwtToken = jwtService.generateToken(teacherAuthenticator);
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(jwtToken);
        return jwtResponse;
    }
}
