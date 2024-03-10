package com.example.madrassaty.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatNotification {
    private long id;
    private long senderId;
    private long receiverId;
    private String content;
}