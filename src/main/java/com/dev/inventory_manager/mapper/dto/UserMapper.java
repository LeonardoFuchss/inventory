package com.dev.inventory_manager.mapper.dto;

import com.dev.inventory_manager.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDto userDto) {
        return User.builder()
                .user(userDto.getUser())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
