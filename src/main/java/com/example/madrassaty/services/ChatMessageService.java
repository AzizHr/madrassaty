package com.example.madrassaty.services;

import com.example.madrassaty.dtos.request.ChatMessageRequest;
import com.example.madrassaty.dtos.response.ChatMessageResponse;
import com.example.madrassaty.exceptions.ChatRoomAlreadyExistsException;
import com.example.madrassaty.exceptions.NotFoundException;

import java.util.List;

public interface ChatMessageService {

    ChatMessageResponse save(ChatMessageRequest chatMessageRequest) throws NotFoundException, ChatRoomAlreadyExistsException;
    List<ChatMessageResponse> findChatMessages(long senderId, long receiverId);

}
