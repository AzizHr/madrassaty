package com.example.madrassaty.services.impl;

import com.example.madrassaty.security.authenticators.ManagerAuthenticator;
import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.ManagerRegisterDTO;
import com.example.madrassaty.dtos.response.AuthResponse;
import com.example.madrassaty.enums.Role;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Manager;
import com.example.madrassaty.repositories.ManagerRepository;
import com.example.madrassaty.repositories.SchoolRepository;
import com.example.madrassaty.services.CloudinaryService;
import com.example.madrassaty.services.ManagerAuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ManagerAuthServiceImpl implements ManagerAuthService {

    private final ManagerRepository managerRepository;
    private final SchoolRepository schoolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;

    @Override
    public AuthResponse login(AuthRequestDTO authRequestDTO) {

        Manager manager = managerRepository.findManagerByEmail(authRequestDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Email or password not valid"));

        ManagerAuthenticator authenticatedManager = new ManagerAuthenticator(manager);
        String jwtToken = jwtService.generateToken(authenticatedManager);
        AuthResponse authResponse = modelMapper.map(manager, AuthResponse.class);
        authResponse.setToken(jwtToken);
        return authResponse;
    }

    @Override
    public AuthResponse register(ManagerRegisterDTO managerRegisterDTO) throws NotFoundException, IOException {
        Manager manager = modelMapper.map(managerRegisterDTO, Manager.class);
        manager.setRole(Role.MANAGER);
        manager.setSchool(schoolRepository.findById(managerRegisterDTO.getSchoolId()).orElseThrow(() -> new NotFoundException("No school found")));
        manager.setPassword(passwordEncoder.encode(managerRegisterDTO.getPassword()));
        if (managerRegisterDTO.getImage() != null) {
            String imageUrl = cloudinaryService.uploadFile(managerRegisterDTO.getImage());
            manager.setImage(imageUrl);
        }
        managerRepository.save(manager);
        ManagerAuthenticator managerAuthenticator = new ManagerAuthenticator(manager);
        String jwtToken = jwtService.generateToken(managerAuthenticator);
        AuthResponse authResponse = modelMapper.map(manager, AuthResponse.class);
        authResponse.setToken(jwtToken);
        return authResponse;
    }
}
