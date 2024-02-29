package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.ChatRoomRequest;
import com.example.madrassaty.dtos.response.ChatRoomResponse;
import com.example.madrassaty.exceptions.NotFoundException;

import java.util.Optional;

public interface ChatRoomService {

    String save(ChatRoomRequest chatRoomRequest) throws NotFoundException;
}
