package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.response.ManagerProfileResponse;
import com.example.madrassaty.dtos.response.StudentProfileResponse;
import com.example.madrassaty.dtos.response.TeacherProfileResponse;
import com.example.madrassaty.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoggedInUserInfoController {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @GetMapping("/student")
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<StudentProfileResponse> getLoggedInStudent() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(userRepository.findByEmail(email));
        return ResponseEntity.ok(modelMapper.map(userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("No student found")), StudentProfileResponse.class));
    }

    @GetMapping("/teacher")
    @PreAuthorize("hasAuthority('TEACHER')")
    public ResponseEntity<TeacherProfileResponse> getLoggedInTeacher() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return ResponseEntity.ok(modelMapper.map(userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("No teacher found")), TeacherProfileResponse.class));
    }

    @GetMapping("/manager")
    @PreAuthorize("hasAuthority('MANAGER')")
    public ResponseEntity<ManagerProfileResponse> getLoggedInManager() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return ResponseEntity.ok(modelMapper.map(userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("No manager found")), ManagerProfileResponse.class));
    }

}
