package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.ChatUserDTO;
import com.example.madrassaty.dtos.response.ProfileResponse;
import com.example.madrassaty.enums.StatusType;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.User;
import com.example.madrassaty.repositories.UserRepository;
import com.example.madrassaty.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public ProfileResponse connect(ChatUserDTO chatUserDTO) throws NotFoundException {
        if(repository.findById(chatUserDTO.getId()).isPresent()) {
            User user = repository.findById(chatUserDTO.getId()).get();
            user.setStatus(StatusType.ONLINE);
            return modelMapper.map(repository.save(user), ProfileResponse.class);
        }
        throw new NotFoundException("No user found");
    }

    @Override
    public ProfileResponse disconnect(ChatUserDTO chatUserDTO) throws NotFoundException {
        if(repository.findById(chatUserDTO.getId()).isPresent()) {
            User user = repository.findById(chatUserDTO.getId()).get();
            user.setStatus(StatusType.ONLINE);
            return modelMapper.map(repository.save(user), ProfileResponse.class);
        }
        throw new NotFoundException("No user found");
    }

    @Override
    public List<ProfileResponse> findConnectedUsers() {
        List<User> users = repository.findAllByStatus(StatusType.ONLINE);
        return users.stream()
                .map(user -> modelMapper.map(user, ProfileResponse.class))
                .collect(Collectors.toList());
    }

}
