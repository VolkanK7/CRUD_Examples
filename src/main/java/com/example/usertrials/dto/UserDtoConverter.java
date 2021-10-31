package com.example.usertrials.dto;

import com.example.usertrials.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto convert(User from){
        return new UserDto(from.getName(),from.getEmail());
    }
}
