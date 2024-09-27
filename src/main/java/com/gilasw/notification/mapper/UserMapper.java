package com.gilasw.notification.mapper;

import com.gilasw.notification.controller.dto.UserDTO;
import com.gilasw.notification.domain.entities.User;

import java.util.function.Function;
import java.util.stream.Collectors;

import static com.gilasw.notification.mapper.CategoryMapper.categoryMapper;
import static com.gilasw.notification.mapper.TypeNotificationMapper.typeNotificationMapper;

public class UserMapper {

    public static Function<User, UserDTO> userMapper = user -> UserDTO.builder()
            .userGuid(user.getUserGuid().toString())
            .name(user.getName())
            .email(user.getEmail())
            .phone(user.getPhone())
            .categories(user.getUserCategories().stream().map(categoryMapper)
                    .collect(Collectors.toSet()))
            .typeNotifications(user.getUserTypeNotifications().stream().map(typeNotificationMapper)
                    .collect(Collectors.toSet()))
            .build();
}
