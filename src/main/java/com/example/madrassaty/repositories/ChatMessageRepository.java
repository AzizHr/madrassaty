package com.example.madrassaty.repositories;

import com.example.madrassaty.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, UUID> {
    List<ChatMessage> findAllBySenderIdAndReceiverId(UUID senderId, UUID receiverId);
}
