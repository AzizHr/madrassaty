package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.User;
import com.example.madrassaty.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @MessageMapping("/user.connect")
    @SendTo("/user/topic")
    public User connect(@Payload User user) {
        userService.connect(user);
        return user;
    }

    @MessageMapping("/user.disconnect")
    public User disconnect(@Payload User user) throws NotFoundException {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> connectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
