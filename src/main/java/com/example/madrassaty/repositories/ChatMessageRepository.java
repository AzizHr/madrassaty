package com.example.madrassaty.repositories;

import com.example.madrassaty.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findAllByChatRoomId(String chatRoomId);
}
