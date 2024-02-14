package com.example.madrassaty.services.impl;

import com.example.madrassaty.authenticators.ManagerAuthenticator;
import com.example.madrassaty.dtos.request.AuthRequestDTO;
import com.example.madrassaty.dtos.request.ManagerRegisterDTO;
import com.example.madrassaty.dtos.response.JwtResponse;
import com.example.madrassaty.enums.Role;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Manager;
import com.example.madrassaty.repositories.ManagerRepository;
import com.example.madrassaty.repositories.SchoolRepository;
import com.example.madrassaty.services.ManagerAuthService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerAuthServiceImpl implements ManagerAuthService {

    private final ManagerRepository managerRepository;
    private final SchoolRepository schoolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    @Override
    public JwtResponse login(AuthRequestDTO authRequestDTO) {

        Manager manager = managerRepository.findManagerByEmail(authRequestDTO.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("Manager not found"));

        ManagerAuthenticator authenticatedManager = new ManagerAuthenticator(manager);
        String jwtToken = jwtService.generateToken(authenticatedManager);
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(jwtToken);
        return jwtResponse;
    }

    @Override
    public JwtResponse register(ManagerRegisterDTO managerRegisterDTO) throws NotFoundException {
        Manager manager = modelMapper.map(managerRegisterDTO, Manager.class);
        manager.setRole(Role.MANAGER);
        manager.setSchool(schoolRepository.findById(1L).orElseThrow(() -> new NotFoundException("No school found")));
        manager.setPassword(passwordEncoder.encode(managerRegisterDTO.getPassword()));
        managerRepository.save(manager);
        ManagerAuthenticator managerAuthenticator = new ManagerAuthenticator(manager);
        String jwtToken = jwtService.generateToken(managerAuthenticator);
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(jwtToken);
        return jwtResponse;
    }
}
