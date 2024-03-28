package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.ChatUserDTO;
import com.example.madrassaty.dtos.response.ProfileResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import java.util.List;

public interface UserService {
    ProfileResponse connect(ChatUserDTO user) throws NotFoundException;

    ProfileResponse disconnect(ChatUserDTO user) throws NotFoundException;

    List<ProfileResponse> findConnectedUsers();
}
