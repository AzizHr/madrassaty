package com.example.madrassaty.services.impl;

import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.ChatRoom;
import com.example.madrassaty.repositories.ChatRoomRepository;
import com.example.madrassaty.repositories.UserRepository;
import com.example.madrassaty.services.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<String> getChatRoomId(
            long senderId,
            long receiverId
    ) throws NotFoundException {
        if(chatRoomRepository.findBySenderIdAndReceiverId(senderId, receiverId).isPresent()) {
            ChatRoom chatRoom = chatRoomRepository.findBySenderIdAndReceiverId(senderId, receiverId).get();
            return Optional.of(chatRoom.getId());
        } else {
            return Optional.of(createChatId(senderId, receiverId));
        }
    }


    @Override
    public String createChatId(long senderId, long receiverId) throws NotFoundException {
        var chatId = String.format("%s_%s", senderId, receiverId);

        ChatRoom senderRecipient = ChatRoom
                .builder()
                .id(chatId)
                .sender(userRepository.findById(senderId).orElseThrow(
                        () -> new NotFoundException("No user found")
                ))
                .receiver(userRepository.findById(receiverId).orElseThrow(
                        () -> new NotFoundException("No user found")
                ))
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .id(chatId)
                .sender(userRepository.findById(receiverId).orElseThrow(
                        () -> new NotFoundException("No user found")
                ))
                .receiver(userRepository.findById(senderId).orElseThrow(
                        () -> new NotFoundException("No user found")
                ))
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }
}