package com.example.madrassaty.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Entity
public class ChatMessage {

    @Id
    private long id;
    private String content;
    private LocalDate createdAt;
    @ManyToOne
    private ChatRoom chatRoom;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User receiver;

}
