package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.enums.StatusType;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.User;
import com.example.madrassaty.repositories.UserRepository;
import com.example.madrassaty.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public void connect(User user) {
        user.setStatus(StatusType.ONLINE);
        userRepository.save(user);
    }

    @Override
    public void disconnect(User user) throws NotFoundException {
        var connectedUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new NotFoundException("No user found"));

        if(connectedUser != null) {
            connectedUser.setStatus(StatusType.ONLINE);
            userRepository.save(connectedUser);
        }
    }

    @Override
    public List<UserResponse> findConnectedUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }
}
