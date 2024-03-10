package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.ChatMessageDTO;
import com.example.madrassaty.dtos.response.ChatMessageResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import java.util.List;

public interface ChatMessageService {
    ChatMessageDTO save(ChatMessageDTO chatMessageDTO) throws NotFoundException;

    List<ChatMessageResponse> findChatMessages(long senderId, long receiverId);
}
