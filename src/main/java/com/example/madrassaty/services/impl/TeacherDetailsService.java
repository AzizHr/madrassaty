package com.example.madrassaty.services.impl;

import com.example.madrassaty.authenticators.TeacherAuthenticator;
import com.example.madrassaty.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherDetailsService implements UserDetailsService {

    private final TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var teacher = teacherRepository.findTeacherByEmail(username).orElseThrow( () -> new UsernameNotFoundException("No teacher found"));
        return new TeacherAuthenticator(teacher);
    }
}
