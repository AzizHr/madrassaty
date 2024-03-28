package com.example.madrassaty.repositories;

import com.example.madrassaty.models.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, UUID> {
    Optional<ChatRoom> findBySenderIdAndReceiverId(UUID senderId, UUID receiverId);
}
