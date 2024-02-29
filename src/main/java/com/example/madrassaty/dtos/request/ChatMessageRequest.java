package com.example.madrassaty.dtos.request;

import com.example.madrassaty.models.ChatRoom;
import com.example.madrassaty.models.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageRequest {
    private long id;
    private String content;
    private LocalDate createdAt;
    private String chatRoomId;
    private long senderId;
    private long receiverId;
}
