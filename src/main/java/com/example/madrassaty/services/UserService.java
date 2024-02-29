package com.example.madrassaty.services;

import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.User;

import java.util.List;

public interface UserService {

    void connect(User user);
    void disconnect(User user) throws NotFoundException;
    public List<UserResponse> findConnectedUsers();

}
