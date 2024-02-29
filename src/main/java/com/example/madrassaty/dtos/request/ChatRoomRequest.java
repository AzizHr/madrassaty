package com.example.madrassaty.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomRequest {
    private String id;
    private String name;
    private long senderId;
    private long receiverId;
}
