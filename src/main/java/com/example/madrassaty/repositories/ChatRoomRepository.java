package com.example.madrassaty.repositories;

import com.example.madrassaty.models.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {}
