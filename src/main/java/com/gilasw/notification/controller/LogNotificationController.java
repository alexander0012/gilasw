package com.gilasw.notification.controller;

import com.gilasw.notification.controller.dto.LogNotificationDTO;
import com.gilasw.notification.service.LogNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static com.gilasw.notification.mapper.LogNotificationMapper.logNotificationMapper;

@Slf4j
@RestController
@RequestMapping("/logNotification")
public class LogNotificationController {

    @Autowired
    private LogNotificationService logNotificationService;

    @GetMapping("/all")
    public List<LogNotificationDTO> getAllLogNotifications() {
        return logNotificationService.getAllLogNotifications().stream().map(logNotificationMapper).toList();
    }
}
