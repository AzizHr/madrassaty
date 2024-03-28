package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.ChatMessageDTO;
import com.example.madrassaty.dtos.response.ChatMessageResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import java.util.List;
import java.util.UUID;

public interface ChatMessageService {
    ChatMessageDTO save(ChatMessageDTO chatMessageDTO) throws NotFoundException;

    List<ChatMessageResponse> findChatMessages(UUID senderId, UUID receiverId);
}
