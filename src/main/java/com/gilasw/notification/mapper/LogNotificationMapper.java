package com.gilasw.notification.mapper;

import com.gilasw.notification.controller.dto.LogNotificationDTO;
import com.gilasw.notification.domain.entities.LogNotification;

import java.util.function.Function;

public class LogNotificationMapper {

    public static Function<LogNotification, LogNotificationDTO> logNotificationMapper = logNotification -> LogNotificationDTO.builder()
            .logNotificationGuid(logNotification.getLogNotificationGuid().toString())
            .message(logNotification.getNotification().getMessage())
            .category(logNotification.getNotification().getCategory().getName())
            .typeNotification(logNotification.getTypeNotification().getName())
            .user(LogNotificationDTO.UserNotificationDTO.builder()
                    .name(logNotification.getUser().getName())
                    .email(logNotification.getUser().getEmail())
                    .phone(logNotification.getUser().getPhone())
                    .build())
            .build();
}
