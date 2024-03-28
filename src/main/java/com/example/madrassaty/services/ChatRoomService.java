package com.example.madrassaty.services;

import com.example.madrassaty.exceptions.NotFoundException;

import java.util.Optional;
import java.util.UUID;

public interface ChatRoomService {
    Optional<UUID> getChatRoomId(UUID senderId, UUID receiverId) throws NotFoundException;
    UUID createChatId(UUID senderId, UUID receiverId) throws NotFoundException;
}
