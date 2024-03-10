package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.ChatUserDTO;
import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import java.util.List;

public interface UserService {
    UserResponse connect(ChatUserDTO user) throws NotFoundException;

    UserResponse disconnect(ChatUserDTO user) throws NotFoundException;

    List<UserResponse> findConnectedUsers();
}
