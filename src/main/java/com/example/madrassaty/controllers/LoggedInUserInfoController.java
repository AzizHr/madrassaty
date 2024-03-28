package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.response.ManagerResponse;
import com.example.madrassaty.dtos.response.StudentResponse;
import com.example.madrassaty.dtos.response.TeacherResponse;
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
    public ResponseEntity<StudentResponse> getLoggedInStudent() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(userRepository.findByEmail(email));
        return ResponseEntity.ok(modelMapper.map(userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("No student found")), StudentResponse.class));
    }

    @GetMapping("/teacher")
    @PreAuthorize("hasAuthority('TEACHER')")
    public ResponseEntity<TeacherResponse> getLoggedInTeacher() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return ResponseEntity.ok(modelMapper.map(userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("No teacher found")), TeacherResponse.class));
    }

    @GetMapping("/manager")
    @PreAuthorize("hasAuthority('MANAGER')")
    public ResponseEntity<ManagerResponse> getLoggedInManager() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return ResponseEntity.ok(modelMapper.map(userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("No manager found")), ManagerResponse.class));
    }

}
