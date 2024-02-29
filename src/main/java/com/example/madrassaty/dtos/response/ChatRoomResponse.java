package com.example.madrassaty.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomResponse {
    private String id;
    private String name;
    private UserResponse sender;
    private UserResponse receiver;
}
