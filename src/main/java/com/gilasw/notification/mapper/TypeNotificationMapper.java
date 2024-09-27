package com.gilasw.notification.mapper;

import com.gilasw.notification.controller.dto.TypeNotificationDTO;
import com.gilasw.notification.domain.entities.UserTypeNotification;

import java.util.function.Function;

public class TypeNotificationMapper {

    public static Function<UserTypeNotification, TypeNotificationDTO> typeNotificationMapper = typeNotification -> TypeNotificationDTO.builder()
            .typeNotificationGuid(typeNotification.getUserTypeNotificationGuid().toString())
            .name(typeNotification.getTypeNotification().getName())
            .build();
}
