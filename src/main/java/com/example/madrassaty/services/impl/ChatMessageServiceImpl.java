package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.ChatMessageRequest;
import com.example.madrassaty.dtos.response.ChatMessageResponse;
import com.example.madrassaty.exceptions.ChatRoomAlreadyExistsException;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.ChatMessage;
import com.example.madrassaty.repositories.ChatMessageRepository;
import com.example.madrassaty.repositories.ChatRoomRepository;
import com.example.madrassaty.repositories.UserRepository;
import com.example.madrassaty.services.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public ChatMessageResponse save(ChatMessageRequest chatMessageRequest) throws NotFoundException, ChatRoomAlreadyExistsException {

        if(!chatRoomRepository.findById(chatMessageRequest.getChatRoomId()).isPresent()) {
            ChatMessage chatMessage = modelMapper.map(chatMessageRequest, ChatMessage.class);
            chatMessage.setChatRoom(chatRoomRepository.findById(chatMessageRequest.getChatRoomId()).orElseThrow(()
                    -> new NotFoundException("No chatRoom found")));

            chatMessage.setSender(userRepository.findById(chatMessageRequest
                            .getSenderId())
                    .orElseThrow(() -> new NotFoundException("No user found")));

            chatMessage.setReceiver(userRepository.findById(chatMessageRequest
                            .getReceiverId())
                    .orElseThrow(() -> new NotFoundException("No user found")));

            return modelMapper.map(chatMessageRepository.save(chatMessage), ChatMessageResponse.class);
        } else {
            throw new ChatRoomAlreadyExistsException("ChatRoom already exists");
        }
    }

    public List<ChatMessageResponse> findChatMessages(long senderId, long receiverId) {
        String chatRoomId = String.format("%_%", senderId, receiverId);
        List<ChatMessage> chatMessages = chatMessageRepository.findAllByChatRoomId(chatRoomId);
        return chatMessages.stream()
                .map(chatMessage -> modelMapper.map(chatMessage, ChatMessageResponse.class))
                .collect(Collectors.toList());
    }
}
