package com.example.madrassaty.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class ChatMessage {

    @Id
    private UUID id;
    private String content;
    @ManyToOne
    private ChatRoom chatRoom;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User receiver;

}
