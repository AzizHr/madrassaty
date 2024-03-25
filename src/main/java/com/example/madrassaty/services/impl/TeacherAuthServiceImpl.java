package com.example.madrassaty.services.impl;

import com.example.madrassaty.enums.StatusType;
import com.example.madrassaty.exceptions.EmailAlreadyInUseException;
import com.example.madrassaty.security.authenticators.TeacherAuthenticator;
import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.TeacherRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.enums.Role;
import com.example.madrassaty.models.Teacher;
import com.example.madrassaty.repositories.TeacherRepository;
import com.example.madrassaty.services.CloudinaryService;
import com.example.madrassaty.services.TeacherAuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TeacherAuthServiceImpl implements TeacherAuthService {

    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;

    @Override
    public AuthResponse login(AuthRequestDTO authRequestDTO) {

        Teacher teacher = teacherRepository.findTeacherByEmail(authRequestDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Email or password not valid"));

        TeacherAuthenticator teacherAuthenticator = new TeacherAuthenticator(teacher);
        String jwtToken = jwtService.generateToken(teacherAuthenticator);
        AuthResponse authResponse = modelMapper.map(teacher, AuthResponse.class);
        authResponse.setToken(jwtToken);
        return authResponse;
    }

    @Override
    public AuthResponse register(TeacherRegisterDTO teacherRegisterDTO) throws IOException, EmailAlreadyInUseException {

        if(teacherRepository.findTeacherByEmail(teacherRegisterDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyInUseException("This email is already in use");
        } else {
            Teacher teacher = modelMapper.map(teacherRegisterDTO, Teacher.class);
            teacher.setRole(Role.TEACHER);
            teacher.setStatus(StatusType.OFFLINE);
            teacher.setPassword(passwordEncoder.encode(teacherRegisterDTO.getPassword()));
            if (teacherRegisterDTO.getImage() != null) {
                String imageUrl = cloudinaryService.uploadFile(teacherRegisterDTO.getImage());
                teacher.setImage(imageUrl);
            }
            teacherRepository.save(teacher);
            TeacherAuthenticator teacherAuthenticator = new TeacherAuthenticator(teacher);
            String jwtToken = jwtService.generateToken(teacherAuthenticator);
            AuthResponse authResponse = modelMapper.map(teacher, AuthResponse.class);
            authResponse.setToken(jwtToken);
            return authResponse;
        }
    }
}
