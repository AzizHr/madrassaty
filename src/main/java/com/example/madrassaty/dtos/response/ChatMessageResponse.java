package com.example.madrassaty.dtos.response;

import com.example.madrassaty.dtos.request.ChatRoomDTO;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessageResponse {
    private long id;
    private String content;
    private ChatRoomDTO chatRoom;
    private ProfileResponse sender;
    private ProfileResponse receiver;
}
