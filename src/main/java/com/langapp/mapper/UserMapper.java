package com.langapp.mapper;

import com.langapp.domain.user.User;
import com.langapp.domain.user.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .age(userDto.getAge())
                .currentLevel(userDto.getCurrentLevel())
                .userPoints(userDto.getUserPoints())
                .registrationDate(userDto.getRegistrationDate())
                .build();
    }

    public UserDto mapToUserDto(final User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .age(user.getAge())
                .currentLevel(user.getCurrentLevel())
                .userPoints(user.getUserPoints())
                .registrationDate(user.getRegistrationDate())
                .build();
    }

    public List<UserDto> mapToUserDtoList(final List<User> users) {
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
