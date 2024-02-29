package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.ChatRoomRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageResponse {
    private long id;
    private String content;
    private LocalDate createdAt;
    private ChatRoomRequest chatRoom;
    private UserResponse sender;
    private UserResponse receiver;
}
