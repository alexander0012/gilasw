package com.gilasw.notification.controller;

import com.gilasw.notification.controller.dto.RequestSendNotification;
import com.gilasw.notification.exception.MessageEmptyException;
import com.gilasw.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping("/sendNotification")
    public void sendNotification(@RequestBody RequestSendNotification requestBody) {
        if (!StringUtils.hasText(requestBody.getMessage())) {
            throw new MessageEmptyException("Message cannot be empty, bad request in the body", new Throwable());
        }

        notificationService.sendNotification(requestBody);
    }

}
