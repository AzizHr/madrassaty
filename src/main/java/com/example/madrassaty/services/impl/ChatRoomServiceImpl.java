package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.ChatRoomRequest;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.ChatRoom;
import com.example.madrassaty.repositories.ChatRoomRepository;
import com.example.madrassaty.repositories.UserRepository;
import com.example.madrassaty.services.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    @Override
    public String save(ChatRoomRequest chatRoomRequest) throws NotFoundException {
        var chatId = String.format("%_%", chatRoomRequest.getSenderId(), chatRoomRequest.getReceiverId());
        var chatName = String.format("chat_%_%", chatRoomRequest.getSenderId(), chatRoomRequest.getReceiverId());
        ChatRoom senderChatRoom = new ChatRoom();
        senderChatRoom.setId(chatId);
        senderChatRoom.setName(chatName);
        senderChatRoom.setSender(userRepository.findById(chatRoomRequest.getSenderId()).orElseThrow(() -> new NotFoundException("No user found")));
        senderChatRoom.setReceiver(userRepository.findById(chatRoomRequest.getReceiverId()).orElseThrow(() -> new NotFoundException("No user found")));

        ChatRoom receiverChatRoom = new ChatRoom();
        receiverChatRoom.setId(chatId);
        receiverChatRoom.setName(chatName);
        receiverChatRoom.setSender(userRepository.findById(chatRoomRequest.getReceiverId()).orElseThrow(() -> new NotFoundException("No user found")));
        receiverChatRoom.setReceiver(userRepository.findById(chatRoomRequest.getSenderId()).orElseThrow(() -> new NotFoundException("No user found")));

        chatRoomRepository.save(senderChatRoom);
        chatRoomRepository.save(receiverChatRoom);
        return chatId;
    }
}
