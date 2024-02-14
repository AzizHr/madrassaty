package com.example.madrassaty.services.impl;

import com.example.madrassaty.authenticators.StudentAuthenticator;
import com.example.madrassaty.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var student = studentRepository.findStudentByEmail(username).orElseThrow( () -> new UsernameNotFoundException("No student found"));
        return new StudentAuthenticator(student);
    }
}
