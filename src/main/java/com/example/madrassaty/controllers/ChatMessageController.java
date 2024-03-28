package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.ChatMessageDTO;
import com.example.madrassaty.dtos.response.ChatMessageResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.ChatNotification;
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
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessageDTO chatMessage) throws NotFoundException {
        ChatMessageDTO savedMsg = chatMessageService.save(chatMessage);
        messagingTemplate.convertAndSendToUser(
                String.valueOf(chatMessage.getReceiverId()), "/queue/messages",
                new ChatNotification(
                        savedMsg.getId(),
                        savedMsg.getSenderId(),
                        savedMsg.getReceiverId(),
                        savedMsg.getContent()
                )
        );
    }

    @GetMapping("/api/messages/{senderId}/{receiverId}")
    public ResponseEntity<List<ChatMessageResponse>> findChatMessages(@PathVariable UUID senderId,
                                                                      @PathVariable UUID receiverId) {
        return ResponseEntity
                .ok(chatMessageService.findChatMessages(senderId, receiverId));
    }
}