package com.example.madrassaty.services.impl;

import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Class;
import com.example.madrassaty.models.Specialty;
import com.example.madrassaty.repositories.ClassRepository;
import com.example.madrassaty.repositories.SpecialtyRepository;
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
    private final SpecialtyRepository specialtyRepository;
    private final ClassRepository classRepository;
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
    public AuthResponse register(StudentRegisterDTO studentRegisterDTO) throws IOException, NotFoundException {
        Student student = modelMapper.map(studentRegisterDTO, Student.class);
        student.setRole(Role.STUDENT);
        student.setPassword(passwordEncoder.encode(studentRegisterDTO.getPassword()));
        if (studentRegisterDTO.getImage() != null) {
            String imageUrl = cloudinaryService.uploadFile(studentRegisterDTO.getImage());
            student.setImage(imageUrl);
        }
        if(specialtyRepository.findById(studentRegisterDTO.getSpecialtyId()).isPresent()) {
            Specialty specialty = specialtyRepository.findById(studentRegisterDTO.getSpecialtyId()).get();
            if(classRepository.findById(studentRegisterDTO.getClassId()).isPresent()) {
                Class aClass = classRepository.findById(studentRegisterDTO.getClassId()).get();
                student.setSpecialty(specialty);
                student.set_class(aClass);
                studentRepository.save(student);
                StudentAuthenticator studentAuthenticator = new StudentAuthenticator(student);
                String jwtToken = jwtService.generateToken(studentAuthenticator);
                AuthResponse authResponse = modelMapper.map(student, AuthResponse.class);
                authResponse.setToken(jwtToken);
                return authResponse;
            }
            throw new NotFoundException("No class found");
        }
        throw new NotFoundException("No specialty found");
    }
}
