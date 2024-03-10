package com.example.madrassaty.controllers;

import com.example.madrassaty.dtos.request.ChatUserDTO;
import com.example.madrassaty.dtos.response.UserResponse;
import com.example.madrassaty.exceptions.NotFoundException;
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
    @SendTo("/user/public")
    public UserResponse addUser(
            @Payload ChatUserDTO user
    ) throws NotFoundException {
        return userService.connect(user);
    }

    @MessageMapping("/user.disconnect")
    @SendTo("/user/public")
    public UserResponse disconnectUser(
            @Payload ChatUserDTO user
    ) throws NotFoundException {
        return userService.disconnect(user);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponse>> connectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}