package com.example.madrassaty.services;

import com.example.madrassaty.exceptions.NotFoundException;

import java.util.Optional;

public interface ChatRoomService {
    Optional<String> getChatRoomId(long senderId, long receiverId) throws NotFoundException;
    String createChatId(long senderId, long receiverId) throws NotFoundException;
}
