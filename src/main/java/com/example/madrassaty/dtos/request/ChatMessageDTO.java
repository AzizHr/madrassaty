package com.example.madrassaty.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDTO {
    private long id;
    private String content;
    private long senderId;
    private long receiverId;
}
