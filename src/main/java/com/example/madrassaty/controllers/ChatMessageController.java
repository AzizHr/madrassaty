package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.ChatMessageRequest;
import com.example.madrassaty.dtos.response.ChatMessageResponse;
import com.example.madrassaty.exceptions.ChatRoomAlreadyExistsException;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.services.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat")
    public void processMessage(
            @Payload ChatMessageRequest chatMessageRequest
    ) throws NotFoundException, ChatRoomAlreadyExistsException {
        ChatMessageResponse chatMessage = chatMessageService.save(chatMessageRequest);
        messagingTemplate.convertAndSendToUser(
                chatMessage.getReceiver().getFirstname(), "/queue/messages", null
        );
    }

    @GetMapping("/messages/{senderId}/{receiverId}")
    public ResponseEntity<List<ChatMessageResponse>> chatMessages(
            @PathVariable long senderId,
            @PathVariable long receiverId
    ) {
        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, receiverId));
    }

}
