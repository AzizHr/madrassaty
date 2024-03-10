package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.ChatMessageDTO;
import com.example.madrassaty.dtos.response.ChatMessageResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.ChatMessage;
import com.example.madrassaty.repositories.ChatMessageRepository;
import com.example.madrassaty.repositories.ChatRoomRepository;
import com.example.madrassaty.services.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository repository;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomServiceImpl chatRoomService;
    private final ModelMapper modelMapper;

    @Override
    public ChatMessageDTO save(ChatMessageDTO chatMessageDTO) throws NotFoundException {
        ChatMessage chatMessage = modelMapper.map(chatMessageDTO, ChatMessage.class);
        var chatId = chatRoomService
                .getChatRoomId(chatMessageDTO.getSenderId(), chatMessageDTO.getReceiverId())
                .orElseThrow(() -> new NotFoundException("No chatroom found"));
        chatMessage.setChatRoom(chatRoomRepository.findById(chatId).get());
        repository.save(chatMessage);
        return chatMessageDTO;
    }

    @Override
    public List<ChatMessageResponse> findChatMessages(long senderId, long receiverId) {
        List<ChatMessage> chatMessages = repository.findAllBySenderIdAndReceiverId(senderId, receiverId);
        return chatMessages.stream()
                .map(chatMessage -> modelMapper.map(chatMessage, ChatMessageResponse.class))
                .collect(Collectors.toList());
    }

}
