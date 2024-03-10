package com.example.madrassaty.services.impl;

import com.example.madrassaty.security.authenticators.ManagerAuthenticator;
import com.example.madrassaty.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerDetailsService implements UserDetailsService {

    private final ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var manager = managerRepository.findManagerByEmail(username).orElseThrow( () -> new UsernameNotFoundException("No manager found"));
        return new ManagerAuthenticator(manager);
    }
}
