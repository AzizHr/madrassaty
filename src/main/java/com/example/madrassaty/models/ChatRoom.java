package com.example.madrassaty.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class ChatRoom {

    @Id
    private String id;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User receiver;
    @OneToMany(mappedBy = "chatRoom")
    private List<ChatMessage> messages;

}
