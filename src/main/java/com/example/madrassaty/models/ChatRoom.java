package com.example.madrassaty.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChatRoom {

    @Id
    private String id;
    private String name;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User receiver;
    @OneToMany(mappedBy = "chatRoom")
    private List<ChatMessage> messages;

}
