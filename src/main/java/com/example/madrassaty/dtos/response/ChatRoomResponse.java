package com.example.madrassaty.dtos.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoomResponse {
    private String id;
    private ProfileResponse sender;
    private ProfileResponse receiver;
}
